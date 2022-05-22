package io.erkki.devrss.core.feeds;

import io.erkki.devrss.core.feed.Feed;
import io.erkki.devrss.core.feed.FeedItem;
import io.erkki.devrss.core.util.WebPageFetcher;
import com.google.common.collect.Streams;
import io.erkki.devrss.core.util.DateUtil;
import org.jsoup.Jsoup;

import javax.inject.Named;
import java.util.List;
import java.util.stream.Stream;

@Named
public class MavenCentralFeed {

    private final WebPageFetcher webPageFetcher;

    public MavenCentralFeed(WebPageFetcher webPageFetcher) {
        this.webPageFetcher = webPageFetcher;
    }

    /**
     * @return Releases from Maven Central (not RCs, betas or such) as a Feed
     */
    public Feed provideReleaseFeed(String feedName, String relativeDependencyUrl, String releaseNotesUrl) {
        var htmlPage = webPageFetcher.fetchAsString("https://mvnrepository.com/artifact/" + relativeDependencyUrl);
        List<FeedItem> entries = parseMavenCentralFeedItems(feedName, relativeDependencyUrl, releaseNotesUrl, htmlPage);
        return new Feed(feedName, entries);
    }

    public static List<FeedItem> parseMavenCentralFeedItems(String feedName,
                                                            String relativeDependencyUrl, String releaseNotesUrl, String htmlPage) {
        return parseReleaseVersions(htmlPage)
                .limit(10) // No need to list more for feeds
                .map(pair -> new FeedItem(pair.version,
                        feedName,
                        "https://mvnrepository.com/artifact/" + relativeDependencyUrl + "-" + pair.version,
                        releaseNotesUrl,
                        DateUtil.tryParseMavenCentralDate(pair.date)))
                .toList();
    }

    private static Stream<VersionDatePair> parseReleaseVersions(String webPage) {
        var document = Jsoup.parse(webPage);

        var versionNames = document
                .select(".vbtn") // All versions, including beta and rc
                .eachText();

        var dates = document
                // Number of td elements changes per row. Taking last-of-type is the stable way to pick date
                .select("table.versions > tbody > tr > td:last-of-type")
                .eachText();

        if (versionNames.size() != dates.size()) {
            var msg = "Fetching cells from table failed. Found %s version names and %s dates"
                    .formatted(versionNames.size(), dates.size());
            throw new RuntimeException(msg);
        }

        return Streams.zip(versionNames.stream(), dates.stream(), VersionDatePair::new);
    }

    private record VersionDatePair(String version, String date) {
    }
}

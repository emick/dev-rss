package com.example.devrss.core.feed;

import com.example.devrss.core.util.WebPageFetcher;
import org.jsoup.Jsoup;

import javax.inject.Named;
import java.util.List;

@Named
public class MavenCentralFeed {

    private WebPageFetcher webPageFetcher;

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

        return parseReleaseVersions(htmlPage).stream()
                .limit(10) // No need to list more for feeds
                .map(versionName -> new FeedItem(versionName,
                        feedName,
                        "https://mvnrepository.com/artifact/" + relativeDependencyUrl + "-" + versionName,
                        releaseNotesUrl,
                        null)) // Date does not matter much
                .toList();
    }

    private static List<String> parseReleaseVersions(String webPage) {
        return Jsoup.parse(webPage)
                .select(".release") // Note: filters beta, RC, etc. versions!
                .eachText();
    }
}

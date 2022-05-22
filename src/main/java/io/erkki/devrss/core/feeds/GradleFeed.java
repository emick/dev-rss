package io.erkki.devrss.core.feeds;

import io.erkki.devrss.core.feed.Feed;
import io.erkki.devrss.core.feed.FeedItem;
import io.erkki.devrss.core.util.DateUtil;
import io.erkki.devrss.core.ports.WebPageFetcher;
import com.google.common.collect.Lists;
import org.jsoup.Jsoup;

import javax.inject.Named;
import java.util.List;

@Named
public class GradleFeed {

    private final WebPageFetcher http;

    // add constructor
    public GradleFeed(WebPageFetcher http) {
        this.http = http;
    }

    public Feed get() {
        var page = Jsoup.parse(http.fetchAsString("https://gradle.org/releases/"));

        // The page does not have any class names to pick and does not nest version and date together.
        var results = page.select(".u-text-with-icon span:nth-of-type(2)").eachText();

        if (results.size() % 2 != 0)
            throw new RuntimeException("Found indivisible amount of version and date texts: " + results.size());

        List<List<String>> versionDatePairs = Lists.partition(results, 2);

        List<FeedItem> entries = versionDatePairs.stream()
                .map(GradleFeed::gradleVersionDatePairToFeedItem)
                .toList();



        return new Feed("Gradle", entries);
    }

    private static FeedItem gradleVersionDatePairToFeedItem(List<String> versionDatePair) {
        String version = versionDatePair.get(0);
        var link = "https://docs.gradle.org/" + version.substring(1) + "/release-notes";
        return new FeedItem(
                version,
                "Gradle",
                link,
                link,
                DateUtil.tryParseGradleDate(versionDatePair.get(1)));
    }
}

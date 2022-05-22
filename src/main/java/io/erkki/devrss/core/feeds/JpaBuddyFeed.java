package io.erkki.devrss.core.feeds;

import io.erkki.devrss.core.feed.Feed;
import io.erkki.devrss.core.feed.FeedItem;
import io.erkki.devrss.core.util.DateUtil;
import io.erkki.devrss.core.util.WebPageFetcher;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import javax.inject.Named;

@Named
public class JpaBuddyFeed {

    private final WebPageFetcher http;

    public JpaBuddyFeed(WebPageFetcher http) {
        this.http = http;
    }

    public Feed get() {
        var url = "https://www.jpa-buddy.com/blog/";

        String body = http.fetchAsString(url);
        var items = Jsoup.parse(body, url)
                .select(".post").stream()
                .map(JpaBuddyFeed::jpaBuddyPostToFeedItem)
                .toList();

        return new Feed("JPA-Buddy blog", items);
    }

    private static FeedItem jpaBuddyPostToFeedItem(Element post) {
        String title = post.select(".title").text();
        String date = post.select(".date").text();
        String link = post.select(".link").attr("abs:href");

        return new FeedItem(
                title + " " + date,
                "JPA-Buddy Blog",
                link,
                link,
                DateUtil.tryParseJpaBuddyDate(date));
    }
}

package io.erkki.devrss.core.feed;

import java.util.List;

/**
 * A rss/atom feed containing feed items.
 */
public record Feed(String name, List<FeedItem> items) {
}

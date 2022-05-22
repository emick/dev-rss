package io.erkki.devrss.core.feed;

import java.util.Date;

/**
 * A feed item, e.g. a single blog post or a comment
 */
public record FeedItem(String title, String author, String identifier, String link, Date publishedDate) {
}

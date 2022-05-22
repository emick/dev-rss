package io.erkki.devrss.core.feed;

/**
 * Renders feed to String format.
 * <p>
 * Abstracts the feed rendering library.
 */
public interface FeedRenderer {
    String render(Feed feed);
}

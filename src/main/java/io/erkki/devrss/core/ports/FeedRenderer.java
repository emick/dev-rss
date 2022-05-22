package io.erkki.devrss.core.ports;

import io.erkki.devrss.core.feed.Feed;

/**
 * Renders feed to String format.
 * <p>
 * Abstracts the feed rendering library.
 */
public interface FeedRenderer {
    String render(Feed feed);
}

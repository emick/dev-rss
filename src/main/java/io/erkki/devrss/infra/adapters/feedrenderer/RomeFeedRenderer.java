package io.erkki.devrss.infra.adapters.feedrenderer;

import io.erkki.devrss.core.feed.Feed;
import io.erkki.devrss.core.feed.FeedItem;
import io.erkki.devrss.core.ports.FeedRenderer;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndEntryImpl;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.feed.synd.SyndFeedImpl;
import com.rometools.rome.io.SyndFeedOutput;

import javax.inject.Named;
import java.util.List;

/**
 * Converts domain objects to Atom feed String.
 */
@Named
public class RomeFeedRenderer implements FeedRenderer {

    @Override
    public String render(Feed feed) {
        List<SyndEntry> entries = feed.items().stream()
                .map(RomeFeedRenderer::feedItemToRomeSyndEntry)
                .toList();

        return RomeFeedRenderer.createFeed(feed.name(), entries);
    }

    private static SyndEntry feedItemToRomeSyndEntry(FeedItem item) {
        SyndEntry entry = new SyndEntryImpl();
        entry.setAuthor(item.author());
        entry.setTitle(item.title());
        entry.setUri(item.identifier()); // Identifier
        entry.setPublishedDate(item.publishedDate());
        entry.setLink(item.link());
        return entry;
    }

    public static String createFeed(String feedName, List<SyndEntry> entries) {
        SyndFeed feed = new SyndFeedImpl();
        feed.setFeedType("atom_0.3");
        feed.setTitle(feedName);
        feed.setEntries(entries);

        try {
            return new SyndFeedOutput().outputString(feed, true);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

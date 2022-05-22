package io.erkki.devrss;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import io.erkki.devrss.core.util.DateUtil;
import org.junit.jupiter.api.Test;

import io.erkki.devrss.core.feed.FeedItem;
import io.erkki.devrss.core.feeds.MavenCentralFeed;

public class ParsingTest {

    @Test
    public void shouldParseMavenCentralPageToFeed() {
        String feedName = "Mockito";
        String relativeDependencyUrl = "org.mockito/mockito-core";
        String releaseNotesUrl = "https://github.com/mockito/mockito/releases";

        String page = TestFiles.mockitoPage();

        List<FeedItem> items = MavenCentralFeed.parseMavenCentralFeedItems(feedName, relativeDependencyUrl, releaseNotesUrl, page);
        assertEquals(10, items.size());

        var item = items.get(0);
        assertEquals("4.1.0", item.title());
        assertEquals("Mockito", item.author());
        assertEquals("https://mvnrepository.com/artifact/org.mockito/mockito-core-4.1.0", item.identifier());
        assertEquals("https://github.com/mockito/mockito/releases", item.link());
        assertEquals(DateUtil.toJavaUtil(LocalDate.of(2021, 11, 1)), item.publishedDate());
    }
}

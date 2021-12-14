package com.example.devrss;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import com.example.devrss.core.feed.FeedItem;
import com.example.devrss.core.feed.MavenCentralFeed;

public class ParsingTest {

    @Test
    public void shouldParseMavenCentralPageToFeed() throws IOException {
        String feedName = "Mockito";
        String relativeDependencyUrl = "org.mockito/mockito-core";
        String releaseNotesUrl = "https://github.com/mockito/mockito/releases";

        String page = Files.readString(new ClassPathResource("mockito-core.html").getFile().toPath());
        List<FeedItem> items = MavenCentralFeed.parseMavenCentralFeedItems(feedName, relativeDependencyUrl, releaseNotesUrl, page);
        assertEquals(10, items.size());

        var item = items.get(0);
        assertEquals("4.1.0", item.title());
        assertEquals("Mockito", item.author());
        assertEquals("https://mvnrepository.com/artifact/org.mockito/mockito-core-4.1.0", item.identifier());
        assertEquals("https://github.com/mockito/mockito/releases", item.link());
        assertNull(item.publishedDate());
    }
}

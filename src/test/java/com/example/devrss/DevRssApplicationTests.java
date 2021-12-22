package com.example.devrss;

import com.example.devrss.api.FeedController;
import com.example.devrss.core.util.WebPageFetcher;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Context initializing test with mocked HTTP.
 */
@SpringBootTest
class DevRssApplicationTests {

    @MockBean
    private WebPageFetcher webPageFetcher;

    @Inject
    private FeedController feedController;

    @Test
    void contextLoads() {
        when(webPageFetcher.fetchAsString("https://mvnrepository.com/artifact/org.mockito/mockito-core"))
                .thenReturn(TestFiles.mockitoPage());

        String feed = feedController.mockito();

        assertEquals("""
            <?xml version="1.0" encoding="UTF-8"?>
            <feed xmlns="http://purl.org/atom/ns#" xmlns:dc="http://purl.org/dc/elements/1.1/" version="0.3">
              <title>Mockito</title>
              <entry>
                <title>4.1.0</title>
                <link rel="alternate" href="https://github.com/mockito/mockito/releases" />
                <author>
                  <name>Mockito</name>
                </author>
                <id>https://mvnrepository.com/artifact/org.mockito/mockito-core-4.1.0</id>
                <dc:creator>Mockito</dc:creator>
              </entry>
              <entry>
                <title>4.0.0</title>
                <link rel="alternate" href="https://github.com/mockito/mockito/releases" />
                <author>
                  <name>Mockito</name>
                </author>
                <id>https://mvnrepository.com/artifact/org.mockito/mockito-core-4.0.0</id>
                <dc:creator>Mockito</dc:creator>
              </entry>
              <entry>
                <title>3.12.4</title>
                <link rel="alternate" href="https://github.com/mockito/mockito/releases" />
                <author>
                  <name>Mockito</name>
                </author>
                <id>https://mvnrepository.com/artifact/org.mockito/mockito-core-3.12.4</id>
                <dc:creator>Mockito</dc:creator>
              </entry>
              <entry>
                <title>3.12.3</title>
                <link rel="alternate" href="https://github.com/mockito/mockito/releases" />
                <author>
                  <name>Mockito</name>
                </author>
                <id>https://mvnrepository.com/artifact/org.mockito/mockito-core-3.12.3</id>
                <dc:creator>Mockito</dc:creator>
              </entry>
              <entry>
                <title>3.12.2</title>
                <link rel="alternate" href="https://github.com/mockito/mockito/releases" />
                <author>
                  <name>Mockito</name>
                </author>
                <id>https://mvnrepository.com/artifact/org.mockito/mockito-core-3.12.2</id>
                <dc:creator>Mockito</dc:creator>
              </entry>
              <entry>
                <title>3.12.1</title>
                <link rel="alternate" href="https://github.com/mockito/mockito/releases" />
                <author>
                  <name>Mockito</name>
                </author>
                <id>https://mvnrepository.com/artifact/org.mockito/mockito-core-3.12.1</id>
                <dc:creator>Mockito</dc:creator>
              </entry>
              <entry>
                <title>3.12.0</title>
                <link rel="alternate" href="https://github.com/mockito/mockito/releases" />
                <author>
                  <name>Mockito</name>
                </author>
                <id>https://mvnrepository.com/artifact/org.mockito/mockito-core-3.12.0</id>
                <dc:creator>Mockito</dc:creator>
              </entry>
              <entry>
                <title>3.11.2</title>
                <link rel="alternate" href="https://github.com/mockito/mockito/releases" />
                <author>
                  <name>Mockito</name>
                </author>
                <id>https://mvnrepository.com/artifact/org.mockito/mockito-core-3.11.2</id>
                <dc:creator>Mockito</dc:creator>
              </entry>
              <entry>
                <title>3.11.1</title>
                <link rel="alternate" href="https://github.com/mockito/mockito/releases" />
                <author>
                  <name>Mockito</name>
                </author>
                <id>https://mvnrepository.com/artifact/org.mockito/mockito-core-3.11.1</id>
                <dc:creator>Mockito</dc:creator>
              </entry>
              <entry>
                <title>3.11.0</title>
                <link rel="alternate" href="https://github.com/mockito/mockito/releases" />
                <author>
                  <name>Mockito</name>
                </author>
                <id>https://mvnrepository.com/artifact/org.mockito/mockito-core-3.11.0</id>
                <dc:creator>Mockito</dc:creator>
              </entry>
            </feed>
            """, feed.replaceAll("\r\n", "\n") // Normalize to \n which is default for text blocks
        );
    }
}

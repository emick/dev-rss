package io.erkki.devrss;

import io.erkki.devrss.api.FeedController;
import io.erkki.devrss.core.ports.WebPageFetcher;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

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
                   <modified>2021-11-30T12:00:00Z</modified>
                   <issued>2021-11-30T12:00:00Z</issued>
                   <dc:creator>Mockito</dc:creator>
                   <dc:date>2021-11-30T12:00:00Z</dc:date>
                 </entry>
                 <entry>
                   <title>4.0.0</title>
                   <link rel="alternate" href="https://github.com/mockito/mockito/releases" />
                   <author>
                     <name>Mockito</name>
                   </author>
                   <id>https://mvnrepository.com/artifact/org.mockito/mockito-core-4.0.0</id>
                   <modified>2021-10-31T12:00:00Z</modified>
                   <issued>2021-10-31T12:00:00Z</issued>
                   <dc:creator>Mockito</dc:creator>
                   <dc:date>2021-10-31T12:00:00Z</dc:date>
                 </entry>
                 <entry>
                   <title>3.12.4</title>
                   <link rel="alternate" href="https://github.com/mockito/mockito/releases" />
                   <author>
                     <name>Mockito</name>
                   </author>
                   <id>https://mvnrepository.com/artifact/org.mockito/mockito-core-3.12.4</id>
                   <modified>2021-08-31T12:00:00Z</modified>
                   <issued>2021-08-31T12:00:00Z</issued>
                   <dc:creator>Mockito</dc:creator>
                   <dc:date>2021-08-31T12:00:00Z</dc:date>
                 </entry>
                 <entry>
                   <title>3.12.3</title>
                   <link rel="alternate" href="https://github.com/mockito/mockito/releases" />
                   <author>
                     <name>Mockito</name>
                   </author>
                   <id>https://mvnrepository.com/artifact/org.mockito/mockito-core-3.12.3</id>
                   <modified>2021-08-31T12:00:00Z</modified>
                   <issued>2021-08-31T12:00:00Z</issued>
                   <dc:creator>Mockito</dc:creator>
                   <dc:date>2021-08-31T12:00:00Z</dc:date>
                 </entry>
                 <entry>
                   <title>3.12.2</title>
                   <link rel="alternate" href="https://github.com/mockito/mockito/releases" />
                   <author>
                     <name>Mockito</name>
                   </author>
                   <id>https://mvnrepository.com/artifact/org.mockito/mockito-core-3.12.2</id>
                   <modified>2021-08-31T12:00:00Z</modified>
                   <issued>2021-08-31T12:00:00Z</issued>
                   <dc:creator>Mockito</dc:creator>
                   <dc:date>2021-08-31T12:00:00Z</dc:date>
                 </entry>
                 <entry>
                   <title>3.12.1</title>
                   <link rel="alternate" href="https://github.com/mockito/mockito/releases" />
                   <author>
                     <name>Mockito</name>
                   </author>
                   <id>https://mvnrepository.com/artifact/org.mockito/mockito-core-3.12.1</id>
                   <modified>2021-08-31T12:00:00Z</modified>
                   <issued>2021-08-31T12:00:00Z</issued>
                   <dc:creator>Mockito</dc:creator>
                   <dc:date>2021-08-31T12:00:00Z</dc:date>
                 </entry>
                 <entry>
                   <title>3.12.0</title>
                   <link rel="alternate" href="https://github.com/mockito/mockito/releases" />
                   <author>
                     <name>Mockito</name>
                   </author>
                   <id>https://mvnrepository.com/artifact/org.mockito/mockito-core-3.12.0</id>
                   <modified>2021-08-31T12:00:00Z</modified>
                   <issued>2021-08-31T12:00:00Z</issued>
                   <dc:creator>Mockito</dc:creator>
                   <dc:date>2021-08-31T12:00:00Z</dc:date>
                 </entry>
                 <entry>
                   <title>3.11.2</title>
                   <link rel="alternate" href="https://github.com/mockito/mockito/releases" />
                   <author>
                     <name>Mockito</name>
                   </author>
                   <id>https://mvnrepository.com/artifact/org.mockito/mockito-core-3.11.2</id>
                   <modified>2021-06-30T12:00:00Z</modified>
                   <issued>2021-06-30T12:00:00Z</issued>
                   <dc:creator>Mockito</dc:creator>
                   <dc:date>2021-06-30T12:00:00Z</dc:date>
                 </entry>
                 <entry>
                   <title>3.11.1</title>
                   <link rel="alternate" href="https://github.com/mockito/mockito/releases" />
                   <author>
                     <name>Mockito</name>
                   </author>
                   <id>https://mvnrepository.com/artifact/org.mockito/mockito-core-3.11.1</id>
                   <modified>2021-06-30T12:00:00Z</modified>
                   <issued>2021-06-30T12:00:00Z</issued>
                   <dc:creator>Mockito</dc:creator>
                   <dc:date>2021-06-30T12:00:00Z</dc:date>
                 </entry>
                 <entry>
                   <title>3.11.0</title>
                   <link rel="alternate" href="https://github.com/mockito/mockito/releases" />
                   <author>
                     <name>Mockito</name>
                   </author>
                   <id>https://mvnrepository.com/artifact/org.mockito/mockito-core-3.11.0</id>
                   <modified>2021-06-30T12:00:00Z</modified>
                   <issued>2021-06-30T12:00:00Z</issued>
                   <dc:creator>Mockito</dc:creator>
                   <dc:date>2021-06-30T12:00:00Z</dc:date>
                 </entry>
               </feed>
               """, feed.replaceAll("\r\n", "\n") // Normalize to \n which is default for text blocks
        );
    }
}

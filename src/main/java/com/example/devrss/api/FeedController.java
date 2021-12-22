package com.example.devrss.api;

import com.example.devrss.core.util.WebPageFetcher;
import com.example.devrss.core.feed.Feed;
import com.example.devrss.core.feed.FeedItem;
import com.example.devrss.core.feed.FeedRenderer;
import com.example.devrss.core.feed.MavenCentralFeed;
import com.example.devrss.core.util.DateUtil;
import com.google.common.collect.Lists;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Provides the atom feeds.
 */
@RestController
@RequestMapping(path = "/feed")
@Cacheable("feeds")
public class FeedController {

    private final FeedRenderer feedRenderer;
    private final WebPageFetcher webPageFetcher;
    private final MavenCentralFeed mavenCentralFeed;

    public FeedController(FeedRenderer feedRenderer, WebPageFetcher webPageFetcher, MavenCentralFeed mavenCentralFeed) {
        this.feedRenderer = feedRenderer;
        this.webPageFetcher = webPageFetcher;
        this.mavenCentralFeed = mavenCentralFeed;
    }

    @GetMapping(value = "/mockito", produces = MediaType.APPLICATION_ATOM_XML_VALUE)
    public String mockito() {
        String feedName = "Mockito";
        String relativeDependencyUrl = "org.mockito/mockito-core";
        String releaseNotesUrl = "https://github.com/mockito/mockito/releases";

        return feedRenderer.render(mavenCentralFeed.provideReleaseFeed(feedName,
                relativeDependencyUrl, releaseNotesUrl));
    }

    @GetMapping(value = "/junit", produces = MediaType.APPLICATION_ATOM_XML_VALUE)
    public String junit() {
        String feedName = "JUnit";
        String relativeDependencyUrl = "org.junit.jupiter/junit-jupiter-engine";
        String releaseNotesUrl = "https://junit.org/junit5/docs/current/release-notes/index.html";

        return feedRenderer.render(mavenCentralFeed.provideReleaseFeed(feedName,
                relativeDependencyUrl, releaseNotesUrl));
    }

    @GetMapping(value = "/selenium", produces = MediaType.APPLICATION_ATOM_XML_VALUE)
    public String selenium() {
        String feedName = "Selenium";
        String relativeDependencyUrl = "org.seleniumhq.selenium/selenium-java";
        String releaseNotesUrl = "https://github.com/SeleniumHQ/selenium/blob/master/java/CHANGELOG";

        return feedRenderer.render(mavenCentralFeed.provideReleaseFeed(feedName,
                relativeDependencyUrl, releaseNotesUrl));
    }

    @GetMapping(value = "/hibernate", produces = MediaType.APPLICATION_ATOM_XML_VALUE)
    public String hibernate() {
        String feedName = "Hibernate";
        String relativeDependencyUrl = "org.hibernate/hibernate-core";
        String releaseNotesUrl = "https://hibernate.org/orm/releases/";

        return feedRenderer.render(mavenCentralFeed.provideReleaseFeed(feedName,
                relativeDependencyUrl, releaseNotesUrl));
    }

    @GetMapping(value = "/spring/core", produces = MediaType.APPLICATION_ATOM_XML_VALUE)
    public String springCore() {
        String feedName = "Spring Core";
        String relativeDependencyUrl = "org.springframework/spring-core";
        String releaseNotesUrl = "https://spring.io/blog/category/releases";

        return feedRenderer.render(mavenCentralFeed.provideReleaseFeed(feedName,
                relativeDependencyUrl, releaseNotesUrl));
    }

    @GetMapping(value = "/spring/boot", produces = MediaType.APPLICATION_ATOM_XML_VALUE)
    public String springBoot() {
        String feedName = "Spring Boot";
        String relativeDependencyUrl = "org.springframework.boot/spring-boot";
        String releaseNotesUrl = "https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.0-Release-Notes";

        return feedRenderer.render(mavenCentralFeed.provideReleaseFeed(feedName,
                relativeDependencyUrl, releaseNotesUrl));
    }

    @GetMapping(value = "/spring/batch", produces = MediaType.APPLICATION_ATOM_XML_VALUE)
    public String springBatch() {
        String feedName = "Spring Batch";
        String relativeDependencyUrl = "org.springframework.batch/spring-batch-core";
        String releaseNotesUrl = "https://spring.io/blog/category/releases";

        return feedRenderer.render(mavenCentralFeed.provideReleaseFeed(feedName,
                relativeDependencyUrl, releaseNotesUrl));
    }

    @GetMapping(value = "/spring/mvc", produces = MediaType.APPLICATION_ATOM_XML_VALUE)
    public String springMvc() {
        String feedName = "Spring MVC";
        String relativeDependencyUrl = "org.springframework/spring-webmvc";
        String releaseNotesUrl = "https://spring.io/blog/category/releases";

        return feedRenderer.render(mavenCentralFeed.provideReleaseFeed(feedName,
                relativeDependencyUrl, releaseNotesUrl));
    }

    @GetMapping(value = "/spring/data", produces = MediaType.APPLICATION_ATOM_XML_VALUE)
    public String springData() {
        String feedName = "Spring Data";
        String relativeDependencyUrl = "org.springframework.data/spring-data-jpa";
        String releaseNotesUrl = "https://docs.spring.io/spring-data/jpa/docs/current/changelog.txt";

        return feedRenderer.render(mavenCentralFeed.provideReleaseFeed(feedName,
                relativeDependencyUrl, releaseNotesUrl));
    }

    @GetMapping(value = "/spring/security", produces = MediaType.APPLICATION_ATOM_XML_VALUE)
    public String springSecurity() {
        String feedName = "Spring Security";
        String relativeDependencyUrl = "org.springframework.security/spring-security-core";
        String releaseNotesUrl = "https://spring.io/blog/category/releases";

        return feedRenderer.render(mavenCentralFeed.provideReleaseFeed(feedName,
                relativeDependencyUrl, releaseNotesUrl));
    }

    @GetMapping(value = "/vaadin", produces = MediaType.APPLICATION_ATOM_XML_VALUE)
    public String vaadin() {
        String feedName = "Vaadin";
        String relativeDependencyUrl = "com.vaadin/vaadin";
        String releaseNotesUrl = "https://vaadin.com/framework/releases";

        return feedRenderer.render(mavenCentralFeed.provideReleaseFeed(feedName,
                relativeDependencyUrl, releaseNotesUrl));
    }

    @GetMapping(value = "/guava", produces = MediaType.APPLICATION_ATOM_XML_VALUE)
    public String guava() {
        String feedName = "Guava";
        String relativeDependencyUrl = "com.google.guava/guava";
        String releaseNotesUrl = "https://github.com/google/guava/releases";

        return feedRenderer.render(mavenCentralFeed.provideReleaseFeed(feedName,
                relativeDependencyUrl, releaseNotesUrl));
    }

    @GetMapping(value = "/flyway", produces = MediaType.APPLICATION_ATOM_XML_VALUE)
    public String flyway() {
        String feedName = "Flyway";
        String relativeDependencyUrl = "org.flywaydb/flyway-core";
        String releaseNotesUrl = "https://flywaydb.org/documentation/releaseNotes";

        return feedRenderer.render(mavenCentralFeed.provideReleaseFeed(feedName,
                relativeDependencyUrl, releaseNotesUrl));
    }

    @GetMapping(value = "/gradle", produces = MediaType.APPLICATION_ATOM_XML_VALUE)
    public String gradle() {
        var page = Jsoup.parse(webPageFetcher.fetchAsString("https://gradle.org/releases/"));

        // The page does not have any class names to pick and does not nest version and date together.
        var results = page.select(".u-text-with-icon span:nth-of-type(2)").eachText();

        if (results.size() % 2 != 0)
            throw new RuntimeException("Found indivisible amount of version and date texts: " + results.size());

        List<List<String>> versionDatePairs = Lists.partition(results, 2);

        List<FeedItem> entries = versionDatePairs.stream()
                .map(FeedController::gradleVersionDatePairToFeedItem)
                .toList();

        return feedRenderer.render(new Feed("Gradle", entries));
    }

    private static FeedItem gradleVersionDatePairToFeedItem(List<String> versionDatePair) {
        String version = versionDatePair.get(0);
        var link = "https://docs.gradle.org/" + version.substring(1) + "/release-notes";
        return new FeedItem(
                version,
                "Gradle",
                link,
                link,
                DateUtil.tryParseGradleDate(versionDatePair.get(1)));
    }

    @GetMapping(value = "/jpabuddyblog", produces = MediaType.APPLICATION_ATOM_XML_VALUE)
    public String jpaBuddyBlog() {
        var url = "https://www.jpa-buddy.com/blog/";

        String body = webPageFetcher.fetchAsString(url);
        var items = Jsoup.parse(body, url)
                .select(".post").stream()
                .map(FeedController::jpaBuddyPostToFeedItem)
                .toList();

        return feedRenderer.render(new Feed("JPA-Buddy blog", items));
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

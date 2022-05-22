package io.erkki.devrss.api;

import io.erkki.devrss.core.feed.FeedRenderer;
import io.erkki.devrss.core.feeds.GradleFeed;
import io.erkki.devrss.core.feeds.JpaBuddyFeed;
import io.erkki.devrss.core.feeds.MavenCentralFeed;
import io.erkki.devrss.core.util.WebPageFetcher;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    private final GradleFeed gradleFeed;

    private final JpaBuddyFeed jpaBuddyFeed;

    public FeedController(FeedRenderer feedRenderer,
                          WebPageFetcher webPageFetcher,
                          MavenCentralFeed mavenCentralFeed,
                          GradleFeed gradleFeed,
                          JpaBuddyFeed jpaBuddyFeed) {
        this.feedRenderer = feedRenderer;
        this.webPageFetcher = webPageFetcher;
        this.mavenCentralFeed = mavenCentralFeed;
        this.gradleFeed = gradleFeed;
        this.jpaBuddyFeed = jpaBuddyFeed;
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
        return feedRenderer.render(gradleFeed.get());
    }

    @GetMapping(value = "/jpabuddyblog", produces = MediaType.APPLICATION_ATOM_XML_VALUE)
    public String jpaBuddyBlog() {
        return feedRenderer.render(jpaBuddyFeed.get());
    }
}

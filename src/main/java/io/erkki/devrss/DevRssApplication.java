package io.erkki.devrss;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Application main class.
 */
@SpringBootApplication
@EnableCaching
public class DevRssApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevRssApplication.class, args);
    }

    @EventListener
    public void printFeedsToConsole(ApplicationStartedEvent event) {
        ApplicationContext applicationContext = event.getApplicationContext();
        RequestMappingHandlerMapping requestMappingHandlerMapping = applicationContext
                .getBean("requestMappingHandlerMapping", RequestMappingHandlerMapping.class);
        Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping
                .getHandlerMethods();

        var feeds = map.keySet().stream()
                .map(handlerMethod -> handlerMethod.getPathPatternsCondition().getFirstPattern().getPatternString())
                .filter(path -> path.startsWith("/feed"))
                .map(path -> "GET" + " " + path)
                .sorted()
                .collect(Collectors.joining("\n"));

        System.out.printf("""
                -------
                Feeds provided:
                        
                %s
                -------
                """, feeds);
    }

    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager("feeds");
        caffeineCacheManager.setCaffeine(Caffeine.newBuilder().expireAfterWrite(5, TimeUnit.MINUTES));
        return caffeineCacheManager;
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .setReadTimeout(Duration.ofSeconds(30))
                .setConnectTimeout(Duration.ofSeconds(30))
                .build();
    }
}

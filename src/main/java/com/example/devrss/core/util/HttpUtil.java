package com.example.devrss.core.util;

import org.springframework.http.MediaType;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;

public class HttpUtil {

    public static String fetchWebPageAsString(final String url) {
        return fetchRestTemplate(url);
    }

    public static HttpResponse<String> fetchWebPage(String url) {
        try {
            HttpRequest request = HttpRequest.newBuilder(URI.create(url))
                    .GET()
                    // FIXME tries to avoid CloudFlare block for MavenCentral, but does not work
                    .header("User-Agent", "Machine")
                    .headers("Content-Type", "text/plain;charset=UTF-8")
                    .build();

            HttpResponse<String> response = HttpClient.newBuilder()
                    .followRedirects(Redirect.ALWAYS)
                    .build()
                    .send(request, BodyHandlers.ofString());

            if (response.statusCode() >= 400 && response.statusCode() < 600) //
                throw new RuntimeException("Fetching '" + url + "' failed with status " + response.statusCode());

            return response;
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * FIXME The method with Java 11 HttpClient should be preferred, but for
     * unknown reason this avoids CloudFlare block in Maven Central.
     */
    private static String fetchRestTemplate(String url) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getInterceptors().add((request, body, execution) -> {
                request.getHeaders().set("User-Agent", "Machine");
                request.getHeaders().setContentType(new MediaType("text", "plain", StandardCharsets.UTF_8));
                return execution.execute(request, body);
            });

            return restTemplate
                    .getForObject(URI.create(url), String.class);
        } catch (HttpClientErrorException e) {
            throw new RuntimeException("Fetching '" + url + "' failed with status " + e.getStatusCode(), e);
        }
    }
}

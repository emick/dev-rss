package com.example.devrss.adapters.webpagefetcher;

import com.example.devrss.core.util.WebPageFetcher;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.net.URI;
import java.nio.charset.StandardCharsets;

@Named
public class RestTemplateWebPageFetcher implements WebPageFetcher {

    private RestTemplate http;

    @Inject
    public RestTemplateWebPageFetcher(RestTemplate http) {
        this.http = http;
    }

    @Override
    public String fetchAsString(String url) {
        try {
            http.getInterceptors().add((request, body, execution) -> {
                request.getHeaders().set("User-Agent", "Machine"); // Avoids some firewall filtering
                request.getHeaders().setContentType(new MediaType("text", "plain", StandardCharsets.UTF_8));
                return execution.execute(request, body);
            });

            return http.getForObject(URI.create(url), String.class);
        } catch (HttpClientErrorException e) {
            throw new RuntimeException("Fetching '" + url + "' failed with status " + e.getStatusCode(), e);
        }
    }
}

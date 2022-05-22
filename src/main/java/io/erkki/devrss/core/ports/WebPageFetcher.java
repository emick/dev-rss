package io.erkki.devrss.core.ports;

/**
 * Fetches HTTP pages.
 */
public interface WebPageFetcher {

    String fetchAsString(String url);
}

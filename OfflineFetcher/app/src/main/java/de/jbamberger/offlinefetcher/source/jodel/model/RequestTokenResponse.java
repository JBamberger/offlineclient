package de.jbamberger.offlinefetcher.source.jodel.model;

public class RequestTokenResponse {
    public final long expirationDate;
    public final String requestToken;

    public RequestTokenResponse(String str, long j) {
        this.requestToken = str;
        this.expirationDate = j;
    }
}

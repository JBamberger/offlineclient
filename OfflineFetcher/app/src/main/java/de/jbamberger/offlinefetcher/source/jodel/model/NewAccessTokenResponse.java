package de.jbamberger.offlinefetcher.source.jodel.model;

public class NewAccessTokenResponse {
    public final String accessToken;
    public final long expirationDate;

    public NewAccessTokenResponse(String str, long j) {
        this.accessToken = str;
        this.expirationDate = j;
    }
}

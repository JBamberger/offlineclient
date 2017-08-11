package de.jbamberger.offlinefetcher.source.jodel.model;

public class NewAccessTokenRequest {
    public String currentClientId;
    public String distinctId;
    public String refreshToken;

    public NewAccessTokenRequest(String str, String str2, String str3) {
        this.refreshToken = str;
        this.currentClientId = str2;
        this.distinctId = str3;
    }
}

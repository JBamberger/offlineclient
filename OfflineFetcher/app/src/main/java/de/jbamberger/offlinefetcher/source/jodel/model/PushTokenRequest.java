package de.jbamberger.offlinefetcher.source.jodel.model;

public class PushTokenRequest {
    public final String clientId;
    public final String pushToken;

    public PushTokenRequest(String str, String str2) {
        this.pushToken = str;
        this.clientId = str2;
    }
}

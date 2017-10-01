package de.jbamberger.offlineclient.source.jodel.model;

public class RequestTokenRequest {
    public final String clientId;
    public final String deviceUid;
    public final String iid;
    public final Location location;

    public RequestTokenRequest(String str, String str2, String str3, Location location) {
        this.clientId = str;
        this.deviceUid = str2;
        this.iid = str3;
        this.location = location;
    }
}

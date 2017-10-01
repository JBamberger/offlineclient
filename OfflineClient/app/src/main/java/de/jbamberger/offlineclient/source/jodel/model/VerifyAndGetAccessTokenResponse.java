package de.jbamberger.offlineclient.source.jodel.model;

public class VerifyAndGetAccessTokenResponse {
    public final String accessToken;
    public String distinctId;
    public final long expirationDate;
    public final String gender;
    public final String refreshToken;
    public boolean returning;

    public VerifyAndGetAccessTokenResponse(String str, String str2, String str3, String str4, boolean z, long j) {
        this.accessToken = str;
        this.refreshToken = str2;
        this.distinctId = str3;
        this.gender = str4;
        this.expirationDate = j;
        this.returning = z;
    }

    public boolean isExistingAccount() {
        return this.returning;
    }
}

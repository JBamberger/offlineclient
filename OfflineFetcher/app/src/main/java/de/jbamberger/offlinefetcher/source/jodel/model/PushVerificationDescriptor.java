package de.jbamberger.offlinefetcher.source.jodel.model;

import android.support.annotation.Keep;

public class PushVerificationDescriptor {
    //TODO: @KeepName
    private long server_time;
    //TODO: @KeepName
    private String verification_code;

    @Keep
    public String getVerificationCode() {
        return this.verification_code;
    }

    @Keep
    public long getServerTime() {
        return this.server_time;
    }
}

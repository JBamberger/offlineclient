package de.jbamberger.offlinefetcher.source.jodel.model;

public class ChannelInfo {
    public final String channel;
    public final int country_followers;
    public final int followers;
    public final String image_url;
    public final boolean unread;

    public ChannelInfo(String str, boolean z, int i, int i2, String str2) {
        this.channel = str;
        this.unread = z;
        this.followers = i;
        this.country_followers = i2;
        this.image_url = str2;
    }
}

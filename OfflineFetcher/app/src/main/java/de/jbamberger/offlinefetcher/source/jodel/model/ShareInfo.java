package de.jbamberger.offlinefetcher.source.jodel.model;

public class ShareInfo {
    public final String imageUrl;
    public final int shareCount;
    public final String url;

    public ShareInfo(String str, String str2, int i) {
        this.url = str;
        this.imageUrl = str2;
        this.shareCount = i;
    }
}

package de.jbamberger.offlineclient.source.jodel.model;

import java.util.List;

public final class PostThreadPage {
    public final boolean isThreadOwn;
    public final boolean isThreadPinned;
    public final String next;
    public final int numPins;
    public final int numShares;
    public final String originalPoster;
    public final List<Post> posts;
    public final boolean readonly;
    public final int remaining;
    public final boolean shareable;
    public final String threadColor;

    public PostThreadPage(List<Post> list, String str, boolean z, boolean z2, int i, int i2, String str2, String str3, boolean z3, boolean z4, int i3) {
        this.posts = list;
        this.next = str;
        this.isThreadOwn = z;
        this.isThreadPinned = z2;
        this.numShares = i;
        this.numPins = i2;
        this.threadColor = str2;
        this.originalPoster = str3;
        this.shareable = z3;
        this.readonly = z4;
        this.remaining = i3;
    }
}

package de.jbamberger.offlineclient.source.jodel.model;

import org.joda.time.DateTime;

public final class UserNotification {
    public final String color;
    public final DateTime lastInteraction;
    public final String message;
    public final String notificationId;
    public final String postId;
    public final boolean read;
    public final String replier;
    public final String scroll;
    public final boolean seen;
    public final int thanksCount;
    public final String thumbnailUrl;
    public final String type;
    public final String userId;
    public final int voteCount;

    public UserNotification(String str, String str2, String str3, String str4, DateTime dateTime, boolean z, boolean z2, String str5, String str6, String str7, int i, int i2, String str8, String str9) {
        this.postId = str;
        this.userId = str2;
        this.message = str3;
        this.type = str4;
        this.lastInteraction = dateTime;
        this.read = z;
        this.seen = z2;
        this.thumbnailUrl = str5;
        this.color = str6;
        this.notificationId = str7;
        this.voteCount = i;
        this.thanksCount = i2;
        this.scroll = str8;
        this.replier = str9;
    }
}

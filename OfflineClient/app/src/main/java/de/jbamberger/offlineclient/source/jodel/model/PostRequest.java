package de.jbamberger.offlineclient.source.jodel.model;

public class PostRequest {
    public final String ancestor;
    public final String channel;
    public final String color;
    public final boolean hasDrawing;
    public final boolean hasHashtag;
    public final byte[] image;
    public final Location location;
    public LocationTag locationTag;
    public final boolean mention;
    public final String message;
    public final boolean to_home;

    public PostRequest(String str, String str2, String str3, byte[] bArr, Location location, String str4, boolean z, LocationTag locationTag, boolean z2) {
        this.message = str;
        this.color = str2;
        this.ancestor = str3;
        this.image = bArr;
        this.location = location;
        this.channel = str4;
        this.to_home = z;
        this.locationTag = locationTag;
        this.hasDrawing = false;
        this.mention = false;
        this.hasHashtag = z2;
    }

    public PostRequest(String str, String str2, String str3, byte[] bArr, Location location, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.message = str + "";
        this.color = str2;
        this.ancestor = str3;
        this.image = bArr;
        this.location = location;
        this.channel = str4;
        this.to_home = z;
        this.hasDrawing = z2;
        this.mention = z3;
        this.hasHashtag = z4;
    }

    @Deprecated
    public String getDraftId() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.ancestor == null) {
            stringBuilder.append(PostDraft.NEW_POST_ID);
        } else {
            stringBuilder.append(this.ancestor);
        }
        if (this.channel != null) {
            //TODO: stringBuilder.append(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
            stringBuilder.append(this.channel);
        }
        return stringBuilder.toString();
    }
}

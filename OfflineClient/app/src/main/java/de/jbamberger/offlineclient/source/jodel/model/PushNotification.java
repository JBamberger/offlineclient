package de.jbamberger.offlineclient.source.jodel.model;

public class PushNotification {
    private final String messageSnippet;
    private final String messageText;
    private final String parentId;
    private final String postColor;
    private final String postId;
    private final String replyId;
    private final String type;
    private boolean scrollToBottom;
    private boolean silent;

    public PushNotification(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.messageText = str;
        this.messageSnippet = str2;
        this.parentId = str3;
        this.postId = str4;
        this.replyId = str5;
        this.postColor = str6;
        this.type = str7;
    }

    public String getMessageText() {
        return this.messageText;
    }

    public String getReplyId() {
        return this.replyId;
    }

    public String getMessageSnippet() {
        return this.messageSnippet;
    }

    public String getPostId() {
        return this.postId;
    }

    public String getPostColor() {
        return this.postColor;
    }

    public boolean isSilent() {
        return this.silent;
    }

    public void setSilent() {
        this.silent = true;
    }

    public boolean isScrollPostDetailToBottom() {
        return this.scrollToBottom;
    }

    public void setScrollPostDetailToBottom() {
        this.scrollToBottom = true;
    }

    public String getParentId() {
        return this.parentId;
    }

    public String getType() {
        return this.type;
    }
}

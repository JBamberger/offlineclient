package de.jbamberger.offlinefetcher.source.jodel.model;

import java.util.concurrent.TimeUnit;

public class PostDraft {
    public static final String NEW_POST_ID = "new_post";
    private int cursorPosition;
    private long draftCreated = System.currentTimeMillis();
    private String draftText;
    private String hashtag;

    public long getDraftCreated() {
        return this.draftCreated;
    }

    public void setDraftCreated(long j) {
        this.draftCreated = j;
    }

    public String getDraftText() {
        return this.draftText;
    }

    public void setDraftText(String str) {
        this.draftText = str;
    }

    public int getCursorPosition() {
        return this.cursorPosition;
    }

    public void setCursorPosition(int i) {
        this.cursorPosition = i;
    }

    public String getHashtag() {
        return this.hashtag;
    }

    public void setHashtag(String str) {
        this.hashtag = str;
    }

    public boolean isNotExpired() {
        return System.currentTimeMillis() - this.draftCreated < TimeUnit.HOURS.toMillis(1);
    }
}

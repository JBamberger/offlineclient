package de.jbamberger.offlineclient.source.jodel.model;

import java.util.List;

public class PostDetailsResponse {
    Post details;
    String next;
    boolean readonly;
    int remaining;
    List<Post> replies;
    boolean shareable;

    public Post getDetails() {
        return this.details;
    }

    public void setDetails(Post post) {
        this.details = post;
    }

    public List<Post> getRepliesThread() {
        return this.replies;
    }

    public void setRepliesThread(List<Post> list) {
        this.replies = list;
    }

    public int getRemaining() {
        return this.remaining;
    }

    public void setRemaining(int i) {
        this.remaining = i;
    }

    public String getNext() {
        return this.next;
    }

    public void setNext(String str) {
        this.next = str;
    }

    public boolean getShareable() {
        return this.shareable;
    }

    public void setShareable(boolean z) {
        this.shareable = z;
    }

    public boolean getReadonly() {
        return this.readonly;
    }

    public void setReadonly(boolean z) {
        this.readonly = z;
    }
}

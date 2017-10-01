package de.jbamberger.offlineclient.source.jodel.model;

import java.util.List;

public class PastDayPosts {
    private final List<Post> replied;
    private final List<Post> voted;

    public PastDayPosts(List<Post> list, List<Post> list2) {
        this.replied = list;
        this.voted = list2;
    }

    public List<Post> getReplied() {
        return this.replied;
    }

    public List<Post> getVoted() {
        return this.voted;
    }
}

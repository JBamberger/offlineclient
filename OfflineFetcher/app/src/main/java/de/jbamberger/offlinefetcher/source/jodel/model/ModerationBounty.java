package de.jbamberger.offlinefetcher.source.jodel.model;

public class ModerationBounty {
    private final Post picturePost;

    public ModerationBounty(Post post) {
        this.picturePost = post;
    }

    public Post getPicturePost() {
        return this.picturePost;
    }
}

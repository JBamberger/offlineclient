package de.jbamberger.offlinefetcher.source.jodel.model;

import java.util.List;

public class GetModerationPostsResponse {
    private final ModerationBounty bounty;
    private final List<ModerationPost> posts;

    public GetModerationPostsResponse(List<ModerationPost> list, ModerationBounty moderationBounty) {
        this.posts = list;
        this.bounty = moderationBounty;
    }

    public List<ModerationPost> getPosts() {
        return this.posts;
    }

    public ModerationBounty getBounty() {
        return this.bounty;
    }
}

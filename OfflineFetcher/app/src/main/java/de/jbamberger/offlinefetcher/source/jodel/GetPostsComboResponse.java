package de.jbamberger.offlinefetcher.source.jodel;


import java.util.List;

public class GetPostsComboResponse {
    private final int countryFollowersCount;
    private final int followersCount;
    private final List<Post> newsfeed;
    private final List<Post> recent;
    private final List<Post> replied;
    private final boolean sponsored;
    private final List stickies;
    private final List<Post> voted;

    public GetPostsComboResponse(List<Post> paramList1, List<Post> paramList2, List<Post> paramList3, int paramInt1, int paramInt2, List<Post> paramList4, List paramList, boolean paramBoolean) {
        this.recent = paramList1;
        this.replied = paramList2;
        this.voted = paramList3;
        this.followersCount = paramInt1;
        this.countryFollowersCount = paramInt2;
        this.newsfeed = paramList4;
        this.stickies = paramList;
        this.sponsored = paramBoolean;
    }

    public int getCountryFollowersCount() {
        return countryFollowersCount;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public List<Post> getNewsfeed() {
        return newsfeed;
    }

    public List<Post> getRecent() {
        return recent;
    }

    public List<Post> getReplied() {
        return replied;
    }

    public boolean isSponsored() {
        return sponsored;
    }

    public List getStickies() {
        return stickies;
    }

    public List<Post> getVoted() {
        return voted;
    }
}

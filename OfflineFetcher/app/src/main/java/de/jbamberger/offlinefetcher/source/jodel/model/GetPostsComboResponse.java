package de.jbamberger.offlinefetcher.source.jodel.model;

import java.util.List;

public class GetPostsComboResponse {
    private final int countryFollowersCount;
    private final int followersCount;
    private final List<Post> newsfeed;
    private final PastDayPosts pastDay;
    private final PastWeekPosts pastWeek;
    private final List<Post> recent;
    private final List<Post> replied;
    private final boolean sponsored;
    private final List<StickyPost> stickies;
    private final List<Post> voted;

    public GetPostsComboResponse(List<Post> list, List<Post> list2, List<Post> list3, int i, int i2,
                                 List<Post> list4, List<StickyPost> list5, boolean z, PastDayPosts
                                         pastDayPosts, PastWeekPosts pastWeekPosts) {
        this.recent = list;
        this.replied = list2;
        this.voted = list3;
        this.followersCount = i;
        this.countryFollowersCount = i2;
        this.newsfeed = list4;
        this.stickies = list5;
        this.sponsored = z;
        this.pastDay = pastDayPosts;
        this.pastWeek = pastWeekPosts;
    }

    public List<Post> getRecent() {
        return this.recent;
    }

    public List<Post> getReplied() {
        return this.replied;
    }

    public List<Post> getVoted() {
        return this.voted;
    }

    public List<StickyPost> getStickies() {
        return this.stickies;
    }

    public List<Post> getNewsfeed() {
        return this.newsfeed;
    }

    public int getFollowersCount() {
        return this.followersCount;
    }

    public int getCountryFollowersCount() {
        return this.countryFollowersCount;
    }

    public boolean isSponsored() {
        return this.sponsored;
    }

    public PastDayPosts getPastDay() {
        return this.pastDay;
    }

    public PastWeekPosts getPastWeek() {
        return this.pastWeek;
    }
}

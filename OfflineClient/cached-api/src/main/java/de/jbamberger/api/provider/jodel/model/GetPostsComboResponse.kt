package de.jbamberger.api.provider.jodel.model

data class GetPostsComboResponse(
        val recent: List<Post>,
        val replied: List<Post>,
        val voted: List<Post>,
        val followersCount: Int,
        val countryFollowersCount: Int,
        val newsfeed: List<Post>,
        val stickies: List<StickyPost>,
        val isSponsored: Boolean,
        val pastDay: PastDayPosts,
        val pastWeek: PastWeekPosts)

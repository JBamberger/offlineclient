package de.jbamberger.api.jodel.model

class GetPostsComboResponse(val recent: List<Post>, val replied: List<Post>, val voted: List<Post>, val followersCount: Int, val countryFollowersCount: Int,
                            val newsfeed: List<Post>, val stickies: List<StickyPost>, val isSponsored: Boolean, val pastDay: PastDayPosts, val pastWeek: PastWeekPosts)

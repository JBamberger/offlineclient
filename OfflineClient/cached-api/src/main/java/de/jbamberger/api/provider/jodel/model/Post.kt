package de.jbamberger.api.provider.jodel.model

import org.joda.time.DateTime

data class Post(
        val postId: String,
        val childCount: Int = 0,
        val children: List<Post>? = null,
        val color: String? = null,
        val createdAt: DateTime? = null,
        val distance: Float = 0.toFloat(),
        val isFromHome: Boolean = false,
        val isGotThanks: Boolean = false,
        val highlight: List<PostHighlight>? = null,
        val imageUrl: String? = null,
        val isFlagged: Boolean = false,
        val isOffline: Boolean = false,
        val isReply: Boolean = false,
        val location: Location? = null,
        val locationTag: LocationTag? = null,
        val message: String? = null,
        val isNotificationsEnabled: Boolean = false,
        val parentId: String? = null,
        val pinCount: Int = 0,
        val isPinned: Boolean = false,
        val postOwn: String? = null,
        val isReadonly: Boolean = false,
        val isRemoved: Boolean = false,
        val removedReason: Int = 0,
        val replier: Int = -1,
        val replierMark: String? = null,
        val replyTimestamp: String? = null,
        val shareCount: Int = 0,
        val thanksCount: Int = 0,
        val thumbnailUrl: String? = null,
        val userHandle: String? = null,
        val voteCount: Int = 0,
        val voted: String? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other !is Post) {
            return false
        }
        return other.postId == this.postId

    }

    override fun hashCode(): Int {
        return this.postId.hashCode()
    }
}

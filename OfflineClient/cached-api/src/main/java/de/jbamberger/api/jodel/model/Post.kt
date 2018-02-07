package de.jbamberger.api.jodel.model

import org.joda.time.DateTime

class Post {
    var childCount: Int = 0
    var children: List<Post>? = null
    var color: String? = null
    var createdAt: DateTime? = null
    var distance: Float = 0.toFloat()
    var isFromHome: Boolean = false
    var isGotThanks: Boolean = false
    var highlight: List<PostHighlight>? = null
    var imageUrl: String? = null
    var isFlagged: Boolean = false
    var isOffline: Boolean = false
    var isReply: Boolean = false
    var location: Location? = null
    var locationTag: LocationTag? = null
    var message: String? = null
    var isNotificationsEnabled: Boolean = false
    var parentId: String? = null
    var pinCount: Int = 0
    var isPinned: Boolean = false
    var postId: String? = null
    var postOwn: String? = null
    var isReadonly: Boolean = false
    var isRemoved: Boolean = false
    var removedReason: Int = 0
    var replier = -1
    var replierMark: String? = null
    var replyTimestamp: String? = null
    var shareCount: Int = 0
    var thanksCount: Int = 0
    var thumbnailUrl: String? = null
    var userHandle: String? = null
    var voteCount: Int = 0
    var voted: String? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other !is Post) {
            return false
        }
        val post = other as Post?
        return if (post!!.postId != null) {
            post.postId == this.postId
        } else false
    }

    override fun hashCode(): Int {
        return this.postId!!.hashCode()
    }
}

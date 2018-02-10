package de.jbamberger.api.provider.reddit

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

@Entity
class RedditPost {

    @PrimaryKey
    var id: Int = 0

    class Comment
}

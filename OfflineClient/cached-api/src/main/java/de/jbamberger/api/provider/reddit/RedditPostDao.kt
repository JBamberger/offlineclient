package de.jbamberger.api.provider.reddit

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

@Dao
interface RedditPostDao {

    @Insert(onConflict = REPLACE)
    fun save(post: RedditPost)

    @Query("SELECT * FROM redditpost WHERE id = :subreddit")
    fun load(subreddit: String): LiveData<RedditPost>

}

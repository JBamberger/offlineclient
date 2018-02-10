package de.jbamberger.api.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import de.jbamberger.api.provider.reddit.RedditPost
import de.jbamberger.api.provider.reddit.RedditPostDao

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

@Database(entities = [RedditPost::class], version = 1)
abstract class OfflineDatabase : RoomDatabase() {
    abstract fun redditPostDao(): RedditPostDao
}

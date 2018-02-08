package de.jbamberger.api.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import de.jbamberger.api.reddit.RedditPostDao;
import de.jbamberger.api.reddit.RedditPost;

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

@Database(entities = {RedditPost.class}, version = 1)
public abstract class OfflineDatabase extends RoomDatabase {
    public abstract RedditPostDao redditPostDao();
}

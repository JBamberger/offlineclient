package de.jbamberger.offlinefetcher.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import de.jbamberger.offlinefetcher.db.entity.RedditPost;
import de.jbamberger.offlinefetcher.db.dao.RedditPostDao;

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

@Database(entities = {RedditPost.class}, version = 1)
public abstract class OfflineDatabase extends RoomDatabase {
    public abstract RedditPostDao redditPostDao();
}

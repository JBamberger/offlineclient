package de.jbamberger.offlineclient.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import de.jbamberger.offlineclient.db.dao.RedditPostDao;
import de.jbamberger.offlineclient.db.entity.RedditPost;

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

@Database(entities = {RedditPost.class}, version = 1)
public abstract class OfflineDatabase extends RoomDatabase {
    public abstract RedditPostDao redditPostDao();
}

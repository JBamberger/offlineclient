package de.jbamberger.offlinefetcher.source.reddit;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

@Database(entities = {RedditPost.class}, version = 1)
public abstract class RedditDatabase extends RoomDatabase {
    public abstract RedditPostDao redditPostDao();
}

package de.jbamberger.offlineclient.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import de.jbamberger.offlineclient.db.entity.RedditPost;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

@Dao
public interface RedditPostDao {

    @Insert(onConflict = REPLACE)
    void save(RedditPost post);

    @Query("SELECT * FROM redditpost WHERE id = :subreddit")
    LiveData<RedditPost> load(String subreddit);

}

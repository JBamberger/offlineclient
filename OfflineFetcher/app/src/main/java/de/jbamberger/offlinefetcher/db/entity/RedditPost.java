package de.jbamberger.offlinefetcher.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

@Entity
public class RedditPost {

    @PrimaryKey
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static class Comment {

    }
}

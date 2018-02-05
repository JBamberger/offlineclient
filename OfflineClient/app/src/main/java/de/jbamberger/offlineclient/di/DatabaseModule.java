package de.jbamberger.offlineclient.di;

import android.arch.persistence.room.Room;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.jbamberger.offlineclient.db.OfflineDatabase;
import de.jbamberger.offlineclient.db.dao.RedditPostDao;

/**
 * Dependency Injection module to provide database related objects.
 *
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

@Module
public class DatabaseModule {

    private static final String DB_NAME = "offline-fetcher-app-db";

    @Provides
    @Singleton
    OfflineDatabase providesDb(Context context) {
        return Room.databaseBuilder(context, OfflineDatabase.class, "main.db").build();
    }

    @Provides
    @Singleton
    RedditPostDao providesRedditPostDao(OfflineDatabase database) {
        return database.redditPostDao();
    }
}

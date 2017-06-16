package de.jbamberger.offlinefetcher;

import android.content.Context;

import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseOpenHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

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
    DatabaseOpenHelper provideDbHelper(Context context) {
        return new DaoMaster.DevOpenHelper(context, DB_NAME);
    }

    @Provides
    @Singleton
    Database provideDatabase(DatabaseOpenHelper helper) {
        return helper.getWritableDb();
    }

    @Provides
    @Singleton
    DaoMaster provideDaoMaster(Database db) {
        return new DaoMaster(db);
    }

    @Provides
    @Singleton
    DaoSession provideDaoSession(DaoMaster daoMaster) {
        return daoMaster.newSession();
    }
}

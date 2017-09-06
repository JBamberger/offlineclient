package de.jbamberger.offlinefetcher.di;

import dagger.Module;

/**
 * Dependency Injection module to provide database related objects.
 *
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

@Module
public class DatabaseModule {

    private static final String DB_NAME = "offline-fetcher-app-db";

    /*@Provides
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
    }*/
}

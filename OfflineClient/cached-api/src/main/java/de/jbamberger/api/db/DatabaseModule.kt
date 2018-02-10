package de.jbamberger.api.db

import android.app.Application
import android.arch.persistence.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Dependency Injection module to provide database related objects.
 *
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

@Module
class DatabaseModule {

    @Provides
    @Singleton
    internal fun providesDb(context: Application): OfflineDatabase {
        return Room.databaseBuilder(context, OfflineDatabase::class.java, DB_NAME).build()
    }

    companion object {
        private const val DB_NAME = "main.sqlite"
    }
}

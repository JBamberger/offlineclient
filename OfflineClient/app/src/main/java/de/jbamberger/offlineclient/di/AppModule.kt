package de.jbamberger.offlineclient.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.Module
import dagger.Provides
import de.jbamberger.api.RepositoryProvider
import de.jbamberger.api.provider.backend.BackendRepository
import de.jbamberger.api.provider.jodel.JodelRepository
import de.jbamberger.api.provider.reddit.RedditRepository
import javax.inject.Singleton

/**
 * Dependency injection module to provide application wide dependencies.
 *
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

@Module(includes = [ViewModelModule::class])
internal class AppModule {

    @Provides
    @Singleton
    fun providesApplicationContext(application: Application): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun providesSharedPreferences(context: Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }

    @Provides
    @Singleton
    fun providesRepository(app: Application): RepositoryProvider {
        return RepositoryProvider(app)
    }

    @Provides
    @Singleton
    fun providesBackendRepository(repo: RepositoryProvider): BackendRepository {
        return repo.getBackendRepository()
    }

    @Provides
    @Singleton
    fun providesJodelRepository(repo: RepositoryProvider): JodelRepository {
        return repo.getJodelRepository()
    }

    @Provides
    @Singleton
    fun providesRedditRepository(repo: RepositoryProvider): RedditRepository {
        return repo.getRedditRepository()
    }
}

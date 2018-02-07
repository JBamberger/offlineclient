package de.jbamberger.api.reddit

import dagger.Module
import dagger.Provides
import de.jbamberger.api.DatabaseModule
import de.jbamberger.api.NetModule
import de.jbamberger.api.db.OfflineDatabase
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Dependency Injection module to provide database related objects.
 *
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

@Module(includes = [DatabaseModule::class, NetModule::class])
internal class RedditModule {

    @Provides
    @Singleton
    internal fun provideRedditApiInterface(retrofitBuilder: Retrofit.Builder): RedditApi {
        return retrofitBuilder.baseUrl(RedditApi.BASE_URL).build().create(RedditApi::class.java)
    }

    @Provides
    @Singleton
    internal fun providesRedditPostDao(database: OfflineDatabase): RedditPostDao {
        return database.redditPostDao()
    }
}

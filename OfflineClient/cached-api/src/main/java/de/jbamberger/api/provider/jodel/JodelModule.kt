package de.jbamberger.api.provider.jodel

import dagger.Module
import dagger.Provides
import de.jbamberger.api.db.DatabaseModule
import de.jbamberger.api.net.NetModule
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Dependency Injection module to provide database related objects.
 *
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

@Module(includes = [DatabaseModule::class, NetModule::class])
internal class JodelModule {
    @Provides
    @Singleton
    internal fun provideJodelApiInterface(retrofitBuilder: Retrofit.Builder): JodelApi {
        return retrofitBuilder.baseUrl(JodelApi.BASE_URL).build().create(JodelApi::class.java)
    }
}

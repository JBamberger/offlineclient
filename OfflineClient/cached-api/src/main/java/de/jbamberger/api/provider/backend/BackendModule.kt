package de.jbamberger.api.provider.backend

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
internal class BackendModule {
    @Provides
    @Singleton
    internal fun provideBackendApiInterface(retrofitBuilder: Retrofit.Builder): BackendApi {
        return retrofitBuilder.baseUrl(BackendApi.BASE_URL).build().create(BackendApi::class.java)
    }
}

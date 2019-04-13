package de.jbamberger.api

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import de.jbamberger.api.provider.backend.BackendModule
import de.jbamberger.api.provider.backend.BackendRepository
import de.jbamberger.api.provider.jodel.JodelModule
import de.jbamberger.api.provider.jodel.JodelRepository
import de.jbamberger.api.provider.reddit.RedditModule
import de.jbamberger.api.provider.reddit.RedditRepository
import javax.inject.Singleton

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */
@Singleton
@Component(modules = [RedditModule::class, JodelModule::class, BackendModule::class])
internal interface CacheComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): CacheComponent
    }

    fun getRedditRepository(): RedditRepository
    fun getJodelRepository(): JodelRepository
    fun getBackendRepository(): BackendRepository
}

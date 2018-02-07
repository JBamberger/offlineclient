package de.jbamberger.api

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import de.jbamberger.api.backend.BackendModule
import de.jbamberger.api.jodel.JodelModule
import de.jbamberger.api.reddit.RedditModule
import javax.inject.Singleton

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */
@Singleton
@Component(modules = [RedditModule::class, JodelModule::class, BackendModule::class])
interface CacheComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): CacheComponent
    }

    fun inject(repository: Repository)
}

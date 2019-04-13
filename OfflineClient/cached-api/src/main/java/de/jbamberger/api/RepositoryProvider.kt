package de.jbamberger.api

import android.app.Application
import de.jbamberger.api.provider.backend.BackendRepository
import de.jbamberger.api.provider.jodel.JodelRepository
import de.jbamberger.api.provider.reddit.RedditRepository

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

class RepositoryProvider(app: Application) {
    private val component: CacheComponent = DaggerCacheComponent.builder()
            .application(app)
            .build()


    fun getRedditRepository(): RedditRepository {
        return component.getRedditRepository()
    }

    fun getJodelRepository(): JodelRepository {
        return component.getJodelRepository()
    }

    fun getBackendRepository(): BackendRepository {
        return component.getBackendRepository()
    }
}

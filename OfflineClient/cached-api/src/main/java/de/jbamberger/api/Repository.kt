package de.jbamberger.api

import android.app.Application
import de.jbamberger.api.backend.BackendRepository
import de.jbamberger.api.jodel.JodelRepository
import de.jbamberger.api.reddit.RedditRepository
import javax.inject.Inject

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

class Repository(app: Application) {
    @Inject
    lateinit var jodelRepository: JodelRepository
        internal set
    @Inject
    lateinit var redditRepository: RedditRepository
        internal set
    @Inject
    lateinit var backendRepository: BackendRepository
        internal set


    init {
        DaggerCacheComponent.builder()
                .application(app)
                .build()
                .inject(this)
    }
}

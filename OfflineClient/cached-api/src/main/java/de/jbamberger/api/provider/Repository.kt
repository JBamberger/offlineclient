package de.jbamberger.api.provider

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import de.jbamberger.api.AppExecutors
import de.jbamberger.api.Resource
import de.jbamberger.api.backend.BackendPost
import de.jbamberger.api.backend.BackendRepository
import de.jbamberger.api.model.StreamContent
import de.jbamberger.api.provider.jodel.JodelRepository
import de.jbamberger.api.provider.jodel.model.Post
import de.jbamberger.api.provider.reddit.RedditPost
import de.jbamberger.api.provider.reddit.RedditRepository
import javax.inject.Inject

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

class Repository
@Inject internal constructor(
        private val executors: AppExecutors,
        private val jodelRepo: JodelRepository,
        private val redditRepo: RedditRepository,
        private val backendRepo: BackendRepository) {

    private var posts = MediatorLiveData<Resource<List<StreamContent>>>()
    private var jodelState: Resource<List<Post>>? = null
    private var redditState: Resource<List<RedditPost>>? = null
    private var backendState: Resource<List<BackendPost>>? = null

    init {
        init()
    }

    private fun init() {
        posts = MediatorLiveData()
        posts.addSource(jodelRepo.getPosts()) {
            jodelState = it
            mergeAndUpdate()
        }
        posts.addSource(redditRepo.getPosts()) {
            redditState = it
            mergeAndUpdate()
        }
        posts.addSource(backendRepo.getPosts()) {
            backendState = it
            mergeAndUpdate()
        }
    }


    fun getPosts(): LiveData<Resource<List<StreamContent>>> {
        init()
        return posts
    }

    private fun mergeAndUpdate() {
        posts.value = backendState
    }
}
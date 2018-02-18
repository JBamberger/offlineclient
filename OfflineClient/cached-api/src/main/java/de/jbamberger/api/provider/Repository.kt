package de.jbamberger.api.provider

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import de.jbamberger.api.AppExecutors
import de.jbamberger.api.Resource
import de.jbamberger.api.model.StreamContent
import de.jbamberger.api.provider.jodel.JodelRepository
import de.jbamberger.api.provider.reddit.RedditRepository
import javax.inject.Inject

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

class Repository
@Inject internal constructor(
        private val executors: AppExecutors,
        private val jodelRepo: JodelRepository,
        private val redditRepo: RedditRepository) {

    private val posts = MutableLiveData<Resource<List<StreamContent>>>()

    fun getPosts(): LiveData<Resource<List<StreamContent>>> {
        return posts; //jodelRepo.getPosts();
    }
}
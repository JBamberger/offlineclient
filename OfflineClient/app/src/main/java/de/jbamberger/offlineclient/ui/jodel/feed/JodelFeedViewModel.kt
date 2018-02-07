package de.jbamberger.offlineclient.ui.jodel.feed

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import de.jbamberger.offlineclient.source.jodel.JodelRepository
import de.jbamberger.offlineclient.source.jodel.model.Post
import de.jbamberger.offlineclient.util.Resource
import javax.inject.Inject

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

class JodelFeedViewModel @Inject
constructor(private val repository: JodelRepository) : ViewModel() {

    val posts: LiveData<Resource<List<Post>>> = repository.posts

    fun refresh() {
        repository.posts
    }
}

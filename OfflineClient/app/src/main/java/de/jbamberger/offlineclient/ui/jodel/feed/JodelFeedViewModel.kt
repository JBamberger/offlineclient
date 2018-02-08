package de.jbamberger.offlineclient.ui.jodel.feed

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import de.jbamberger.api.Resource
import de.jbamberger.api.jodel.JodelRepository
import de.jbamberger.api.jodel.model.Post
import javax.inject.Inject

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

class JodelFeedViewModel @Inject
constructor(private val repository: JodelRepository) : ViewModel() {

    val posts: LiveData<Resource<List<Post>>> = repository.getPosts()

    fun refresh() {
        repository.getPosts()
    }
}

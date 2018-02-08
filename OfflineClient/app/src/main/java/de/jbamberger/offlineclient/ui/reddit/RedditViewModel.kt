package de.jbamberger.offlineclient.ui.reddit

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import de.jbamberger.api.reddit.RedditPost
import de.jbamberger.api.reddit.RedditRepository
import javax.inject.Inject

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

class RedditViewModel @Inject
constructor(private val repo: RedditRepository) : ViewModel() {
    var post: LiveData<RedditPost>? = null
        private set


    fun init(subreddit: String) {
        if (this.post != null) {
            return
        }
        post = repo.getRedditPost(subreddit)
    }
}

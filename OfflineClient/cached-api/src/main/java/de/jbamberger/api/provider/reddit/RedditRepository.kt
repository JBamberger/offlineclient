package de.jbamberger.api.provider.reddit

import android.arch.lifecycle.LiveData
import de.jbamberger.api.AppExecutors
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */
@Singleton
class RedditRepository @Inject internal constructor(
        private val api: RedditApi,
        private val executor: AppExecutors,
        private val redditPostDao: RedditPostDao) {

    fun getRedditPost(subreddit: String): LiveData<RedditPost> {
        refreshRedditPosts(subreddit)
        return redditPostDao.load(subreddit)
    }

    private fun refreshRedditPosts(subreddit: String) {
        executor.networkIO().execute {
            val postExists = false//redditPostDao.hasRedditPost(TIMEOUT);
            if (!postExists) {
                api.getPosts(subreddit).enqueue(object : Callback<RedditPost> {
                    override fun onResponse(call: Call<RedditPost>, response: Response<RedditPost>) {
                        // error case is left out for brevity
                        executor.diskIO().execute { redditPostDao.save(response.body()!!) }
                    }

                    override fun onFailure(call: Call<RedditPost>, t: Throwable) {

                    }
                })
            }
        }
    }
}

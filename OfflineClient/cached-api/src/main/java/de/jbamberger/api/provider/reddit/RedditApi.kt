package de.jbamberger.api.provider.reddit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

internal interface RedditApi {


    @GET("r/{subReddit}/")
    fun getPosts(@Path("subReddit") subReddit: String): Call<RedditPost>

    @GET("r/{subReddit}/comments/{postId}/{postName}")
    fun getPostComments(@Path("subReddit") subReddit: String, @Path("postId") postId: String, @Query("postName") postName: String): Call<RedditPost.Comment>

    companion object {
        val BASE_URL = "https://reddit.com/"
    }
}
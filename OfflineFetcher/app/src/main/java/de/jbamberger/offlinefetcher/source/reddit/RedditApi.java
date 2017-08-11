package de.jbamberger.offlinefetcher.source.reddit;

import de.jbamberger.offlinefetcher.db.entity.RedditPost;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

public interface RedditApi
{

    public static final String BASE_URL = "https://reddit.com/";


    @GET("r/{subReddit}/")
    Call<RedditPost> getPosts(@Path("subReddit") String subReddit);

    @GET("r/{subReddit}/comments/{postId}/{postName}")
    Call<RedditPost.Comment> getPostComments(@Path("subReddit") String subReddit, @Path("postId") String postId, @Query("postName") String postName);
}
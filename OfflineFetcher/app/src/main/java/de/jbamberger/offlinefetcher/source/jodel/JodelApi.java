package de.jbamberger.offlinefetcher.source.jodel;

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface JodelApi
{

    public static final String BASE_URL = "https://api.go-tellm.com:443/api/";
/*
    @GET("/v2/posts/location/popular")
    public abstract Call<GetPostsResponse> getMostPopularPosts(@Query("after") String paramString, @Query("lat") double paramDouble1, @Query("lng") double paramDouble2, @Query("home") boolean paramBoolean1, @Query("skipHometown") boolean paramBoolean2);

    @GET("/v3/pictures/location")
    public abstract Call<GetPostsResponse> getMostRecentPictures(@Query("after") String paramString, @Query("limit") int paramInt, @Query("home") boolean paramBoolean);

    @GET("/v2/posts/location/")
    public abstract Call<GetPostsResponse> getMostRecentPosts(@Query("after") String paramString, @Query("lat") double paramDouble1, @Query("lng") double paramDouble2, @Query("home") boolean paramBoolean1, @Query("skipHometown") boolean paramBoolean2);
*/

    @GET("v2/posts/{postId}/")
    public abstract Call<Post> getPost(@Path("postId") String postId, @Query("highlight") String highlight, @Query("home") boolean home);

    @GET("v3/posts/{id}/details")
    public abstract Call<PostDetailsResponse> getPostDetails(@Path("id") String paramString1, @Query("highlight") String paramString2, @Query("details") boolean paramBoolean1, @Query("reply") String paramString3, @Query("reversed") boolean paramBoolean2, @Query("origin") String paramString4);

    @GET("v3/posts/location/combo")
    public abstract Call<GetPostsComboResponse> getPostsCombo(@Query("lat") double lat, @Query("lng") double lng, @Query("stickies") boolean stickies, @Query("home") boolean home, @Query("skipHometown") boolean skipHometown);

}

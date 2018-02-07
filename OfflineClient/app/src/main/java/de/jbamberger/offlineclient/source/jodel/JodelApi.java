package de.jbamberger.offlineclient.source.jodel;

import android.arch.lifecycle.LiveData;

import de.jbamberger.offlineclient.source.ApiResponse;
import de.jbamberger.offlineclient.source.jodel.model.GetPostsComboResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

public interface JodelApi {

    String BASE_URL = "https://api.go-tellm.com:443/api/";

    @GET("v3/posts/location/combo")
    LiveData<ApiResponse<GetPostsComboResponse>> getPostsCombo(
            @Query("lat") double lat,
            @Query("lng") double lng,
            @Query("stickies") boolean stickies,
            @Query("home") boolean home,
            @Query("skipHometown") boolean skipHometown);
}

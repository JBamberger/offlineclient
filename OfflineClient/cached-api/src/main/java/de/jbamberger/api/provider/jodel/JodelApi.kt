package de.jbamberger.api.provider.jodel

import de.jbamberger.api.provider.jodel.model.GetPostsComboResponse
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */

internal interface JodelApi {

    @GET("v3/posts/location/combo")
    fun getPostsCombo(
            @Query("lat") lat: Double,
            @Query("lng") lng: Double,
            @Query("stickies") stickies: Boolean,
            @Query("home") home: Boolean,
            @Query("skipHometown") skipHometown: Boolean): Flowable<GetPostsComboResponse>

    companion object {
        val BASE_URL = "https://api.go-tellm.com:443/api/"
    }
}

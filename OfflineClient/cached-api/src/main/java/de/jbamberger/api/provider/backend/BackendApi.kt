package de.jbamberger.api.provider.backend

import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */
internal interface BackendApi {

    companion object {
        val BASE_URL: String = "https://jbamberger.de"
    }

    @GET("/v1/fcm/register")
    fun updateToken(@Query("old_id") old: String, @Query("new_id") new: String): Flowable<String>

    @GET("/v1/fcm/register")
    fun insertToken(@Query("new_id") new: String): Flowable<String>

    @GET("/data/stream")
    fun getSampleStream(): Flowable<List<BackendPost>>

}
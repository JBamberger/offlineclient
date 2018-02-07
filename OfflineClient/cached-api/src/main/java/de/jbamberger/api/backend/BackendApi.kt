package de.jbamberger.api.backend

import android.arch.lifecycle.LiveData
import de.jbamberger.api.ApiResponse
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
    fun updateToken(@Query("old_id") old: String, @Query("new_id") new: String): LiveData<ApiResponse<String>>

    @GET("/v1/fcm/register")
    fun insertToken(@Query("new_id") new: String): LiveData<ApiResponse<String>>

}
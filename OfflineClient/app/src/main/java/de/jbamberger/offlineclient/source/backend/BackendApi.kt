package de.jbamberger.offlineclient.source.backend

import android.arch.lifecycle.LiveData
import de.jbamberger.offlineclient.source.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */
interface BackendApi {

    companion object {
        val BASE_URL: String = "https://jbamberger.de"
    }

    @GET("/v1/fcm/register")
    fun updateToken(@Query("old_id") old: String, @Query("new_id") new: String): LiveData<ApiResponse<String>>

    @GET("/v1/fcm/register")
    fun insertToken(@Query("new_id") new: String): LiveData<ApiResponse<String>>

}
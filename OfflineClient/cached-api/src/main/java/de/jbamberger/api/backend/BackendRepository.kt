package de.jbamberger.api.backend

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.LiveDataReactiveStreams
import de.jbamberger.api.ApiResponse
import de.jbamberger.api.AppExecutors
import de.jbamberger.api.NetworkBoundResource
import de.jbamberger.api.Resource
import de.jbamberger.api.model.StreamContent
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com)
 */
@Singleton
class BackendRepository @Inject
internal constructor(val appExecutors: AppExecutors, val api: BackendApi) {

    fun updateToken(old: String, new: String) {
        Timber.d("updateToken %s\n%s", old, new)
        if (old.isBlank()) {
            if (!new.isBlank()) {
                api.insertToken(new).subscribe(
                        { Timber.d("Status: ", it) },
                        { Timber.e(it, "Could not send token to backend!") })
            }
        } else {
            if (old == new) {
                return
            } else {
                api.updateToken(old, new)
                        .subscribe(
                                { Timber.d("Status: ", it) },
                                { Timber.e(it, "Could not send token to backend!") })
            }
        }
    }

    fun getPosts(): LiveData<Resource<List<StreamContent>>> {
        return object : NetworkBoundResource<List<StreamContent>, List<StreamContent>>(appExecutors) {
            var items: List<StreamContent>? = null

            override fun saveCallResult(item: List<StreamContent>) {
                items = item
            }

            override fun shouldFetch(data: List<StreamContent>?): Boolean {
                return data == null
            }

            override fun loadFromDb(): LiveData<List<StreamContent>?> {
                return object : LiveData<List<StreamContent>?>() {
                    init {
                        postValue(items)
                    }
                }
            }

            override fun createCall(): LiveData<ApiResponse<List<StreamContent>>> {
                val responseStream = api.getSampleStream()
                        .map { ApiResponse<List<StreamContent>>(it) }
                        .onErrorReturn { ApiResponse(it) }
                return LiveDataReactiveStreams.fromPublisher(responseStream)
            }
        }.asLiveData()
    }
}
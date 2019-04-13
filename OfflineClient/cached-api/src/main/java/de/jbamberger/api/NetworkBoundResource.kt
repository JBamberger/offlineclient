package de.jbamberger.api

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.support.annotation.MainThread
import android.support.annotation.WorkerThread

/**
 * A generic class that can provide a resource backed by both the sqlite database and the network.
 *
 *
 * You can read more about it in the [Architecture
 * Guide](https://developer.android.com/arch).
 *
 * @param <ResultType>
 * @param <RequestType>
 */
class NetworkBoundResource<ResultType, RequestType>
@MainThread
internal constructor(
        private val appExecutors: AppExecutors,
        private val source: Source<ResultType, RequestType>) {

    private val result = MediatorLiveData<Resource<ResultType>>()

    init {
        result.value = Resource.Loading<ResultType>(null)
        val dbSource = source.loadFromDb()
        result.addSource(dbSource) { data ->
            result.removeSource(dbSource)
            if (source.shouldFetch(data)) {
                fetchFromNetwork(dbSource)
            } else {
                result.addSource(dbSource) { result.value = Resource.Success(it!!) }
            }
        }
    }

    private fun fetchFromNetwork(dbSource: LiveData<ResultType?>) {
        val apiResponse = source.createCall()
        // we re-attach dbSource as a new source, it will dispatch its latest value quickly
        result.addSource(dbSource) { result.setValue(Resource.Loading(it)) }
        result.addSource(apiResponse) { response ->
            result.removeSource(apiResponse)
            result.removeSource(dbSource)

            when (response) {
                is ApiResponse.Success -> {
                    appExecutors.diskIO.execute {
                        source.saveCallResult(source.processResponse(response))
                        appExecutors.mainThread.execute {
                            // we specially request a new live data,
                            // otherwise we will get immediately last cached value,
                            // which may not be updated with latest results received from network.
                            result.addSource(source.loadFromDb()) {
                                result.value = Resource.Success(it!!)
                            }
                        }
                    }
                }
                is ApiResponse.Error -> {
                    result.addSource(dbSource) {
                        result.value = Resource.Error(source.onFetchFailed(response), it)
                    }
                }
            }
        }

    }

    fun asLiveData(): LiveData<Resource<ResultType>> {
        return result
    }

    interface Source<ResultType, RequestType> {

        fun onFetchFailed(error: ApiResponse.Error<RequestType>): Throwable {
            return error.error
        }

        @WorkerThread
        fun processResponse(response: ApiResponse.Success<RequestType>): RequestType {
            return response.body
        }

        @WorkerThread
        fun saveCallResult(item: RequestType)

        @MainThread
        fun shouldFetch(data: ResultType?): Boolean

        @MainThread
        fun loadFromDb(): LiveData<ResultType?>

        @MainThread
        fun createCall(): LiveData<ApiResponse<RequestType>>
    }
}

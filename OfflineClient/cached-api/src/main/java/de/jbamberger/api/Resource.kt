package de.jbamberger.api

/**
 * A generic class that holds a value with its loading status.
 *
 * @param <T>
</T> */
sealed class Resource<out T> {
    class Success<out T>(val data: T) : Resource<T>()
    class Loading<out T>(val data: T?) : Resource<T>()
    class Error<out T>(val message: Throwable, val data: T?) : Resource<T>()
}

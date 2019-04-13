package de.jbamberger.api

/**
 * A generic class that holds a value with its loading status.
 *
 * @param <T>
 */
sealed class Resource<out T> {
    class Success<out T> internal constructor(val data: T) : Resource<T>()
    class Loading<out T> internal constructor(val data: T?) : Resource<T>()
    class Error<out T> internal constructor(val message: Throwable, val data: T?) : Resource<T>()
}

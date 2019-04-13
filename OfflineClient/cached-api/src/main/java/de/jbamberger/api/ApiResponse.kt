package de.jbamberger.api


sealed class ApiResponse<T> {
    class Success<T> internal constructor(val body: T) : ApiResponse<T>()
    class Error<T> internal constructor(val error: Throwable) : ApiResponse<T>()
}

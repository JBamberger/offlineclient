package de.jbamberger.api


sealed class ApiResponse<T> {
    class Success<T>(val body: T) : ApiResponse<T>()
    class Error<T>(val error: Throwable) : ApiResponse<T>()
}

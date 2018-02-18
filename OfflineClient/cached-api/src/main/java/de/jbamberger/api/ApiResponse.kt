package de.jbamberger.api


class ApiResponse<T> {
    val body: T?
    val error: Throwable?


    constructor(body: T) {
        this.body = body
        this.error = null
    }

    constructor(error: Throwable) {
        this.body = null
        this.error = error
    }
}

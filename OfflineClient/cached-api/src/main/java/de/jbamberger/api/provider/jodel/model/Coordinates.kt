package de.jbamberger.api.provider.jodel.model

import com.squareup.moshi.Json

data class Coordinates(
        @Json(name = "lat") val latitude: Double,
        @Json(name = "lng") val longitude: Double)

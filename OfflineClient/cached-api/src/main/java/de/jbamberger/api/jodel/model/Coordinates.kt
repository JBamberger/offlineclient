package de.jbamberger.api.jodel.model

import com.google.gson.annotations.SerializedName

class Coordinates(
        @SerializedName("lat") val latitude: Double,
        @SerializedName("lng") val longitude: Double)
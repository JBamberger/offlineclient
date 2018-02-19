package de.jbamberger.api.provider.jodel.model

import android.location.Address
import com.squareup.moshi.Json

class Location(
        val name: String,
        val city: String,
        val country: String,
        @Json(name="loc_coordinates") val coordinates: Coordinates,
        @Json(name="loc_accuracy") val accuracy: Float) {

    val latitude: Double
        get() = coordinates.latitude

    val longitude: Double
        get() = coordinates.longitude

    constructor(name: String, city: String, country: String, lat: Double, lng: Double, accuracy: Float) : this(name, city, country, Coordinates(lat, lng), accuracy)

    constructor(address: Address) : this(address.locality, address.locality, address.countryCode, address.latitude, address.longitude, 0.0f)

}

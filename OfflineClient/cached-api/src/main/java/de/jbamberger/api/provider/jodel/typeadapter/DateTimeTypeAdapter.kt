package de.jbamberger.api.provider.jodel.typeadapter

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.ToJson
import org.joda.time.DateTime
import org.joda.time.format.ISODateTimeFormat
import java.lang.IllegalArgumentException

class DateTimeTypeAdapter {
    @FromJson
    fun fromJson(date: String): DateTime {
        try {
        return ISODateTimeFormat.dateTime().parseDateTime(date)

        } catch (e: IllegalArgumentException) {
            throw JsonDataException()
        }
    }

    @ToJson
    fun toJson(dateTime: DateTime): String {
        return ISODateTimeFormat.dateTime().print(dateTime)
    }
}

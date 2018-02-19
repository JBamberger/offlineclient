package de.jbamberger.api.net

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.ToJson
import org.joda.time.LocalDateTime
import org.joda.time.format.DateTimeFormat
import java.lang.IllegalArgumentException

/**
 * @author Jannik Bamberger (dev.jbamberger@gmail.com
 */
class LocalDateTimeDeSerializer {

    @ToJson
    fun serialize(src: LocalDateTime): String {
        return src.toString(DATE_PATTERN)
    }

    @FromJson
    fun deserialize(json: String): LocalDateTime {
        try {

            return LocalDateTime.parse(json, DateTimeFormat.forPattern(DATE_PATTERN))
        } catch (e: IllegalArgumentException) {
            throw JsonDataException()
        }
    }

    companion object {
        private val DATE_PATTERN = "yyyy-mm-dd"
    }
}

package de.jbamberger.offlineclient.util

import com.google.gson.*
import org.joda.time.LocalDateTime
import org.joda.time.format.DateTimeFormat
import java.lang.reflect.Type

/**
 * @author Jannik
 * @version 14.08.2016.
 */
class LocalDateTimeDeSerializer : JsonSerializer<LocalDateTime>, JsonDeserializer<LocalDateTime> {

    override fun serialize(src: LocalDateTime, typeOfSrc: Type, context: JsonSerializationContext): JsonElement {
        return JsonPrimitive(src.toString(DATE_PATTERN))
    }

    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): LocalDateTime {
        return LocalDateTime.parse(json.asJsonPrimitive.asString, DateTimeFormat.forPattern(DATE_PATTERN))
    }

    companion object {

        private val DATE_PATTERN = "yyyy-mm-dd"
    }
}

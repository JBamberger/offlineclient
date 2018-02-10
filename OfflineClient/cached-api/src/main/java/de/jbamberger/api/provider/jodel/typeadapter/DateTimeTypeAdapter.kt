package de.jbamberger.api.provider.jodel.typeadapter

import com.google.gson.*
import org.joda.time.DateTime
import org.joda.time.format.ISODateTimeFormat
import java.lang.reflect.Type

class DateTimeTypeAdapter : JsonDeserializer<DateTime>, JsonSerializer<DateTime> {
    override fun deserialize(jsonElement: JsonElement, type: Type, jsonDeserializationContext: JsonDeserializationContext): DateTime {
        return ISODateTimeFormat.dateTime().parseDateTime(jsonElement.asString)
    }

    override fun serialize(dateTime: DateTime, type: Type, jsonSerializationContext: JsonSerializationContext): JsonElement {
        return JsonPrimitive(ISODateTimeFormat.dateTime().print(dateTime))
    }
}

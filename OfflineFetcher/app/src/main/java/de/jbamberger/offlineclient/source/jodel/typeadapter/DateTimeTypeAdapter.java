package de.jbamberger.offlineclient.source.jodel.typeadapter;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;

import java.lang.reflect.Type;

public class DateTimeTypeAdapter implements JsonDeserializer<DateTime>, JsonSerializer<DateTime> {
    public DateTime deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        return ISODateTimeFormat.dateTime().parseDateTime(jsonElement.getAsString());
    }

    public JsonElement serialize(DateTime dateTime, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(ISODateTimeFormat.dateTime().print(dateTime));
    }
}

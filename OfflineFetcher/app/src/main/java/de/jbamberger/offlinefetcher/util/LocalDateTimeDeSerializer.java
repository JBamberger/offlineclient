package de.jbamberger.offlinefetcher.util;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;

import java.lang.reflect.Type;

/**
 * @author Jannik
 * @version 14.08.2016.
 */
public class LocalDateTimeDeSerializer implements JsonSerializer<LocalDateTime>, JsonDeserializer<LocalDateTime> {

    private static final String DATE_PATTERN = "yyyy-mm-dd";

    @Override
    public JsonElement serialize(LocalDateTime src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(src.toString(DATE_PATTERN));
    }

    @Override
    public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        return LocalDateTime.parse(json.getAsJsonPrimitive().getAsString(), DateTimeFormat.forPattern(DATE_PATTERN));
    }
}

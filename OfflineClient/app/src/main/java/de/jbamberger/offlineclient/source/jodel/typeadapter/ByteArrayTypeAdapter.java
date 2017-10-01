package de.jbamberger.offlineclient.source.jodel.typeadapter;

import android.util.Base64;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class ByteArrayTypeAdapter implements JsonDeserializer<byte[]>, JsonSerializer<byte[]> {
    public JsonElement serialize(byte[] bArr, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(Base64.encodeToString(bArr, 2));
    }

    public byte[] deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        return Base64.decode(jsonElement.getAsString(), 2);
    }
}

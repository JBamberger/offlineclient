package de.jbamberger.api.jodel.typeadapter

import android.util.Base64
import com.google.gson.*
import java.lang.reflect.Type

class ByteArrayTypeAdapter : JsonDeserializer<ByteArray>, JsonSerializer<ByteArray> {
    override fun serialize(bArr: ByteArray, type: Type, jsonSerializationContext: JsonSerializationContext): JsonElement {
        return JsonPrimitive(Base64.encodeToString(bArr, 2))
    }

    override fun deserialize(jsonElement: JsonElement, type: Type, jsonDeserializationContext: JsonDeserializationContext): ByteArray {
        return Base64.decode(jsonElement.asString, 2)
    }
}

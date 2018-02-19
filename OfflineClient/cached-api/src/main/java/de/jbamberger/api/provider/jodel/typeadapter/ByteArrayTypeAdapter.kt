package de.jbamberger.api.provider.jodel.typeadapter

import android.util.Base64
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson

class ByteArrayTypeAdapter {
    @ToJson
    fun serialize(bArr: ByteArray): String {
        return Base64.encodeToString(bArr, 2)
    }

    @FromJson
    fun deserialize(jsonElement: String): ByteArray {
        return Base64.decode(jsonElement, 2)
    }
}

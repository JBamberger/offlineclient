package de.jbamberger.api.provider.jodel

import android.content.Context
import android.provider.Settings
import android.util.Base64
import de.jbamberger.api.FileUtils
import java.io.File
import java.nio.charset.Charset
import javax.crypto.Cipher
import javax.crypto.Cipher.DECRYPT_MODE
import javax.crypto.Cipher.ENCRYPT_MODE
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.PBEKeySpec
import javax.crypto.spec.SecretKeySpec


class PreferenceCodec(context: Context) {

    private val key: ByteArray

    companion object {
        private val charset = Charset.forName("UTF-8")
        private const val TRANSFORMATION = "AES"
        private const val ALGORITHM = "AES"
        private const val KEY_ALGORITHM = "PBKDF2WithHmacSHA1"
        private const val KEY_ITERATIONS = 1000
        private const val KEY_SIZE = 256
    }

    init {
        try {
            val installationId = FileUtils.readFile(
                    File(context.filesDir.absoluteFile.toString() + "/INSTALLATION"), "utf-8")

            this.key = generateKey(context, installationId)
        } catch (e: Exception) {
            throw IllegalStateException(e)
        }

    }

    fun generateKey(context: Context, installationId: String): ByteArray {
        val password = ("com.tellm.android.app" + installationId).toCharArray()
        val salt = Settings.Secure
                .getString(context.contentResolver, Settings.Secure.ANDROID_ID)
                .toByteArray()
        val keySpec = PBEKeySpec(password, salt, KEY_ITERATIONS, KEY_SIZE)
        return SecretKeyFactory.getInstance(KEY_ALGORITHM)
                .generateSecret(keySpec)
                .encoded
    }

    fun encryptString(plainText: String): String {
        if (plainText == "") {
            return plainText
        }

        val localCipher = Cipher.getInstance(TRANSFORMATION)
        localCipher.init(ENCRYPT_MODE, SecretKeySpec(key, ALGORITHM)) //encrypt mode
        return encodeBase64(localCipher.doFinal(plainText.toByteArray(charset)))

    }

    fun decryptString(cipherText: String): String {
        if (cipherText == "") {
            return cipherText
        }

        val localCipher = Cipher.getInstance(TRANSFORMATION)
        localCipher.init(DECRYPT_MODE, SecretKeySpec(key, ALGORITHM))// decrypt mode
        return String(localCipher.doFinal(decodeBase64(cipherText)), charset)

    }

    private fun decodeBase64(paramString: String): ByteArray {
        return Base64.decode(paramString, Base64.NO_PADDING or Base64.NO_WRAP)
    }

    private fun encodeBase64(paramArrayOfByte: ByteArray): String {
        return Base64.encodeToString(paramArrayOfByte, Base64.NO_PADDING or Base64.NO_WRAP)
    }
}
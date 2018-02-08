package de.jbamberger.api.jodel

import android.content.Context
import android.provider.Settings
import android.util.Base64
import de.jbamberger.api.FileUtils
import java.io.File
import java.nio.charset.Charset
import java.security.NoSuchAlgorithmException
import java.security.spec.InvalidKeySpecException
import javax.crypto.Cipher
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.PBEKeySpec
import javax.crypto.spec.SecretKeySpec


class SecurePreferences(context: Context) {
    private val key: ByteArray

    init {
        try {
            val installationId = FileUtils.readFile(File(context.filesDir.absoluteFile.toString() + "/INSTALLATION"), "utf-8")

            this.key = generateKey(context, installationId)
        } catch (e: Exception) {
            throw IllegalStateException(e)
        }

    }

    @Throws(NoSuchAlgorithmException::class, InvalidKeySpecException::class)
    fun generateKey(context: Context, installationId: String): ByteArray {
        val keySpec = PBEKeySpec(("com.tellm.android.app" + installationId).toCharArray(),
                Settings.Secure.getString(context.contentResolver, Settings.Secure.ANDROID_ID).toByteArray(), 1000, 256)
        return SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(keySpec).encoded
    }

    fun decodeBase64(paramString: String): ByteArray {
        return Base64.decode(paramString, 3)
    }

    fun encryptString(plainText: String?): String? {
        if (plainText == null || plainText == "") {
            return plainText
        }
        try {
            val localCipher = Cipher.getInstance("AES")
            localCipher.init(1, SecretKeySpec(key, "AES")) //encrypt mode
            return encodeBase64(localCipher.doFinal(plainText.toByteArray(charset("UTF-8"))))
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return null
    }

    fun decryptString(cipherText: String?): String? {
        if (cipherText == null || cipherText == "") {
            return cipherText
        }
        try {
            val localCipher = Cipher.getInstance("AES")
            localCipher.init(2, SecretKeySpec(key, "AES"))// decrypt mode
            return String(localCipher.doFinal(decodeBase64(cipherText)), Charset.forName("UTF-8"))
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return null
    }

    fun encodeBase64(paramArrayOfByte: ByteArray): String {
        return Base64.encodeToString(paramArrayOfByte, 3)
    }

}
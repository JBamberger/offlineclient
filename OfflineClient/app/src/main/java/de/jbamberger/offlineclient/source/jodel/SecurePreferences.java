package de.jbamberger.offlineclient.source.jodel;

import android.content.Context;
import android.provider.Settings;
import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import de.jbamberger.offlineclient.util.FileUtils;
import de.jbamberger.offlineclient.util.base64.Base64;


public class SecurePreferences {
    private final byte[] key;

    public SecurePreferences(Context context) {
        try {
            String installationId = FileUtils.INSTANCE.readFile(new File(context.getFilesDir().getAbsoluteFile() + "/INSTALLATION"), "utf-8");

            this.key = generateKey(context, installationId);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public byte[] generateKey(Context context, String installationId) throws NoSuchAlgorithmException, InvalidKeySpecException {
        PBEKeySpec keySpec = new PBEKeySpec(("com.tellm.android.app" + installationId).toCharArray(),
                Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID).getBytes(), 1000, 256);
        return SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(keySpec).getEncoded();
    }

    public byte[] decodeBase64(String paramString) {
        return Base64.decode(paramString, 3);
    }

    public String encryptString(String plainText) {
        if (plainText == null || plainText.equals("")) {
            return plainText;
        }
        try {
            Cipher localCipher = Cipher.getInstance("AES");
            localCipher.init(1, new SecretKeySpec(key, "AES")); //encrypt mode
            return encodeBase64(localCipher.doFinal(plainText.getBytes("UTF-8")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String decryptString(String cipherText) {
        if (cipherText == null || cipherText.equals("")) {
            return cipherText;
        }
        try {
            Cipher localCipher = Cipher.getInstance("AES");
            localCipher.init(2, new SecretKeySpec(key, "AES"));// decrypt mode
            return new String(localCipher.doFinal(decodeBase64(cipherText)), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String encodeBase64(byte[] paramArrayOfByte) {
        return Base64.encodeToString(paramArrayOfByte, 3);
    }

}
package com.example.coding1reward.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

public class EncryUtils {
    private static final String AES_ALGORITHM = "AES";
    private static final byte[] keyValue =
            new byte[] { 'T', 'h', 'e', 'B', 'e', 's', 't',
                    'S', 'e', 'c', 'r','e', 't', 'K', 'e', 'y' };

    public static String AesEncrypt(String valueToEnc) throws Exception {
        Key key = new SecretKeySpec(keyValue, AES_ALGORITHM);
        Cipher c = Cipher.getInstance(AES_ALGORITHM);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encValue = c.doFinal(valueToEnc.getBytes());
        String encryptedValue = Base64.getEncoder().encodeToString(encValue);
        return encryptedValue;
    }
}

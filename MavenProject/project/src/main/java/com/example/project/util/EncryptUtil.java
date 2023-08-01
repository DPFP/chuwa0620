package com.example.project.util;

import java.util.Base64;

public class EncryptUtil {
    public static String convertJsonToBase64(String data) {
        return Base64.getEncoder().encodeToString(data.getBytes());
    }
}

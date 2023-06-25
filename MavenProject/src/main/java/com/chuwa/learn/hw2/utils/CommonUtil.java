package com.chuwa.learn.hw2.utils;

import java.util.UUID;

public class CommonUtil {

    /**
     * generate UUID
     * @return
     */
    public static String generateUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 32);
    }
}

package com.chuwa.rewardprogram.util;

import java.util.UUID;

public class RandomHelper {

    public static String generateRandomToken() {
        return UUID.randomUUID().toString();
    }
}


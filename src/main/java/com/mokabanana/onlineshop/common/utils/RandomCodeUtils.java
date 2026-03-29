package com.mokabanana.onlineshop.common.utils;

import java.util.concurrent.ThreadLocalRandom;

public class RandomCodeUtils {

    private static final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private RandomCodeUtils() {}

    public static String randomAlphanumeric(int length) {
        ThreadLocalRandom rand = ThreadLocalRandom.current();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARS.charAt(rand.nextInt(CHARS.length())));
        }
        return sb.toString();
    }
}

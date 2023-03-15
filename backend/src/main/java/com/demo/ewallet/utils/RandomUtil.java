package com.demo.ewallet.utils;

import java.util.Random;

public class RandomUtil {

    private static String randomAlphanumeric(int length) {
        int leftLimit = 48;
        int rightLimit = 122;
        Random random = new Random();
        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static String generatePassKey() {
        return randomAlphanumeric(16);
    }

}

package com.demo.ewallet.utils;


import java.math.BigInteger;
import java.security.MessageDigest;


public class MD5Util {

    private static final String MD5 = "MD5";

    public static MD5Util md5Util;

    private MD5Util() {
    }

    public static MD5Util getInstance() {
        if (md5Util == null) {
            synchronized (MD5Util.class) {
                if (md5Util == null) {
                    md5Util = new MD5Util();
                }
            }
        }
        return md5Util;
    }

    public String md5(String desc, String key) {
        if (desc == null || key == null) {
            return null;
        }

        try {
            MessageDigest md = MessageDigest.getInstance(MD5);
            md.update(desc.getBytes(Constants.CHARACTER_UTF_8));
            md.update(key.getBytes(Constants.CHARACTER_UTF_8));
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
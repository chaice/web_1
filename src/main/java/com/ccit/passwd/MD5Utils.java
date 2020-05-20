package com.ccit.passwd;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
    /**
     * 生成MD5密文（32位）
     * @param str 源字符串
     * @return
     */
    public static String encrypt(String str) {
        String result = null;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] b = messageDigest.digest();
            int i;
            StringBuilder builder = new StringBuilder();
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0) i += 256;
                if (i < 16) builder.append("0");
                builder.append(Integer.toHexString(i));
            }
            result = builder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 生成MD5密文
     * @param str
     * @param salt
     * @return
     */
    public static String encrypt(String str, String salt) {
        return encrypt(str.concat(salt));
    }


    /**
     * 生成MD5密文
     * @param str
     * @param count
     * @param salt
     * @return
     */
    public static String encrypt(String str, int count, String salt) {
        int i = 0;
        while (i++ < count) {
            str = encrypt(str);
        }
        return encrypt(str, salt);
    }
}

package com.imooc.oa.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author : [zqwzh]
 * @version : [v1.0]
 * @createTime : [2021-09-19 15:45]
 */
public class MD5Utils {
    public static String md5Digest(String source) {
        return DigestUtils.md2Hex(source);
    }

    public static String md5Digest(String source,Integer salt) {
        char[] chars = source.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char)(chars[i] + salt);
        }

        String target = new String(chars);
        System.out.println(target);
        return DigestUtils.md5Hex(target);

    }
}

package com.imooc.oa.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class MD5UtilsTest {

    @Test
    public void md5Digest() {
        String s = new MD5Utils().md5Digest("123456");
        System.out.println(s);
    }

    @Test
    public void md5DigestAddSalt() {
        String s = MD5Utils.md5Digest("123456",888);

        System.out.println(s);
    }
}
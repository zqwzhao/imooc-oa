package com.imooc.oa.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class ResponseUtilsTest {

    @Test
    public void put() {
        ResponseUtils put = new ResponseUtils("LoginException", "密码错误").put("class", "XXXclass");
        String s = put.toJsonString();
        System.out.println(s);
    }
}
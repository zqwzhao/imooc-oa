package com.imooc.oa.service.exception;

/**
 * @author : [zqwzh]
 * @version : [v1.0]
 * @createTime : [2021-09-19 14:25]
 */
public class LoginException extends RuntimeException{
    public LoginException(String message) {
        super(message);
    }
}

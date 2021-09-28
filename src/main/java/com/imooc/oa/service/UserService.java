package com.imooc.oa.service;

import com.imooc.oa.entity.User;
import com.imooc.oa.mapper.UserMapper;
import com.imooc.oa.service.exception.LoginException;
import com.imooc.oa.utils.MD5Utils;

/**
 * @author : [zqwzh]
 * @version : [v1.0]
 * @createTime : [2021-09-19 14:22]
 */
public class UserService {
    private UserMapper userMapper = new UserMapper();

    /**
     * 根据前台输入进行登录效验
     * @param username 用户名
     * @param password 密码
     * @return 效验通过，返回包含用户信息的User类
     * @throws LoginException 用户登录异常
     */
    public User checkLogin(String username,String password) {
        User user = userMapper.selectByUsername(username);
        if (user == null) {
            throw new LoginException("用户名不存在");
        }
        String md5 = MD5Utils.md5Digest(password, user.getSalt());

        if (!md5.equals(user.getPassword())) {
            throw new LoginException("密码错误");
        }
        return user;
    }
}

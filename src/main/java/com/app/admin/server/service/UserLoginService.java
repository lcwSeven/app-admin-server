package com.app.admin.server.service;

import com.app.admin.server.bean.ServerResponse;


/**
 * @author: liucaiwen
 * @date: 2019/3/17 13:55
 */
public interface UserLoginService {

    /**
     * 用户登录
     *
     * @param userName 用户名
     * @param password 密码
     * @return 返回
     */
    ServerResponse userLogin(String userName, String password);
}

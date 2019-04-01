package com.app.admin.server.service;

import com.app.admin.server.bean.AppUser;
import com.app.admin.server.bean.ServerResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author: liucaiwen
 * @date: 2019/3/26 23:29
 */
public interface UserDetailService extends UserDetailsService {

    /**
     * 用户注册
     *
     * @param appUser 用户信息
     * @return 返回
     */
    ServerResponse registerUser(AppUser appUser);

    /**
     * 更新用户
     *
     * @param appUser 用户信息
     * @return 返回
     */
    ServerResponse updateUser(AppUser appUser);

}

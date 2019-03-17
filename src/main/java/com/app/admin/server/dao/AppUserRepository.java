package com.app.admin.server.dao;

import com.app.admin.server.bean.AppUser;
import org.springframework.stereotype.Repository;

/**
 * AppUserDAO继承基类
 *
 * @author liucaiwen
 * @date 2019/03/17
 */
@Repository
public interface AppUserRepository extends MyBatisBaseDao<AppUser, Integer> {

    /**
     * 根据用户名查询用户
     *
     * @param userName 用户名
     * @return 返回
     */
    AppUser selectByUserName(String userName);
}
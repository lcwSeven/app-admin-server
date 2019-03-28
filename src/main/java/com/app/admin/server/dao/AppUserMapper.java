package com.app.admin.server.dao;

import com.app.admin.server.bean.AppUser;
import com.app.admin.server.bean.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * AppUserDAO继承基类
 *
 * @author liucaiwen
 * @date 2019/03/17
 */
@Repository
public interface AppUserMapper {

    /**
     * 根据用户名查询用户
     *
     * @param userName 用户名
     * @return 返回
     */
    AppUser loadUserByUsername(String userName);


    /**
     * 通过主键删除
     * @param userId 主键ID
     * @return 返回
     */
     AppUser loadUserByPrimaryKey(Integer userId);

    /**
     * 根据用户ID 获取该用户角色
     *
     * @param userId 用户ID
     * @return 角色列表
     */
    List<Role> getRolesByUserId(Integer userId);
}
package com.app.admin.server.dao;

import com.app.admin.server.bean.AppRole;
import com.app.admin.server.bean.AppUser;
import org.apache.ibatis.annotations.Param;
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
    AppUser loadUserByUsername(@Param("userName") String userName);


    /**
     * 通过主键查询
     *
     * @param userId 主键ID
     * @return 返回
     */
    AppUser loadUserByPrimaryKey(@Param("userId") Integer userId);

    /**
     * 根据用户ID 获取该用户角色
     *
     * @param userId 用户ID
     * @return 角色列表
     */
    List<AppRole> getRolesByUserId(@Param("userId") Integer userId);

    /**
     * 新增用户
     *
     * @param appUser 用户信息
     * @return 返回
     */
    int insertAppUser(AppUser appUser);

    /**
     * 更新用户
     *
     * @param appUser 用户信息
     * @return 返回
     */
    int updateAppUser(AppUser appUser);

    /**
     * 获取所有的用户
     *
     * @return
     */
    List<AppUser> getAllAppUsers();
}
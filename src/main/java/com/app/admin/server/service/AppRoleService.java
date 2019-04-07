package com.app.admin.server.service;

import com.app.admin.server.bean.AppRole;
import com.app.admin.server.bean.ServerResponse;

import java.util.List;

/**
 * @author: liucaiwen
 * @date: 2019/4/3 22:08
 */
public interface AppRoleService {
    /**
     * 获取所有的角色
     *
     * @return 返回
     */
    List<AppRole> getAppRoles();

    /**
     * 新增角色
     *
     * @param roleName   角色名称
     * @param roleZhName 角色名称
     * @return 返回
     */
    ServerResponse addRole(String roleName, String roleZhName);

    /**
     * 通过主键删除角色
     *
     * @param roleId 角色ID
     * @return 返回
     */
    ServerResponse deleteRoleById(Integer roleId);
}

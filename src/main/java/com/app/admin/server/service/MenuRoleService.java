package com.app.admin.server.service;

/**
 * @author: liucaiwen
 * @date: 2019/4/7 22:37
 */
public interface MenuRoleService {
    /**
     * 更新角色权限
     *
     * @param roleId  角色ID
     * @param menuIds 菜单IDS
     * @return 返回
     */
    int updateMenuRole(Integer roleId, Integer[] menuIds);
}

package com.app.admin.server.service;

import com.app.admin.server.bean.AppMenu;

import java.util.List;

/**
 * @author: liucaiwen
 * @date: 2019/3/25 22:36
 */
public interface MenuService {

    /**
     * 获取所有菜单
     *
     * @return
     */
    List<AppMenu> getAllMenu();

    /**
     * 根据用户ID 获取菜单
     *
     * @return 返回用户菜单
     */
    List<AppMenu> getMenusByUserId();

    /**
     * 根据角色ID 获取菜单树
     *
     * @param roleId 角色ID
     * @return 返回用户角色菜单
     */
    List<Integer> getMenuTreeByRoleId(Integer roleId);

    /**
     * 获取菜单树
     *
     * @return 返回菜单
     */
    List<AppMenu> menuTree();
}

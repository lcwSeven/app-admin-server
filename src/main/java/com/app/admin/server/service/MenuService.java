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
}

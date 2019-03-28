package com.app.admin.server.dao;

import com.app.admin.server.bean.AppMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: liucaiwen
 * @date: 2019/3/27 22:41
 */
@Repository
public interface AppMenuMapper {
    /**
     * 获取所有的菜单
     *
     * @return 菜单列表
     */
    List<AppMenu> getAllMenu();

    /**
     * 根据用户ID 获取菜单列表
     *
     * @param userId 用户ID
     * @return 菜单列表
     */
    List<AppMenu> getMenusByUserId(Integer userId);


    /**
     * 菜单树
     * @return 返回
     */
    List<AppMenu> menuTree();

    /**
     * 根据角色ID 获取菜单
     * @param roleId 角色ID
     * @return 返回
     */
    List<Integer> getMenusByRoleId(Integer roleId);
}

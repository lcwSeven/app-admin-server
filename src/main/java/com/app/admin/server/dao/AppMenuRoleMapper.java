package com.app.admin.server.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


/**
 * @author: liucaiwen
 * @date: 2019/3/27 22:41
 */
@Repository
public interface AppMenuRoleMapper {
    /**
     * 根据角色ID 删除菜单
     *
     * @param roleId
     * @return
     */
    int deleteMenuByRid(Integer roleId);

    /**
     * 根据角色权限
     *
     * @param roleId  角色ID
     * @param menuIds 菜单IDS
     * @return 返回
     */
    int addMenu(@Param("roleId") Integer roleId, @Param("menuIds") Integer[] menuIds);

}

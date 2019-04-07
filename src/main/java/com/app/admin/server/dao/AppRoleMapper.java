package com.app.admin.server.dao;

import com.app.admin.server.bean.AppRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: liucaiwen
 * @date: 2019/3/31 13:58
 */
@Repository
public interface AppRoleMapper {

    /**
     * 获取角色
     *
     * @return 返回角色列表
     */
    List<AppRole> appRoles();

    /**
     * 新增角色
     *
     * @param roleName   角色名
     * @param roleZhName 角色中文名称
     * @return 返回
     */
    int addNewRole(@Param("roleName") String roleName, @Param("roleZhName") String roleZhName);

    /**
     * 根据主键删除角色
     *
     * @param roleId 主键ID
     * @return 返回
     */
    int deleteRoleById(Integer roleId);
}

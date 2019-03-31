package com.app.admin.server.bean;

import java.io.Serializable;

/**
 * app_role
 * @author liucaiwen
 * @date 2019/03/31
 */
public class AppRole implements Serializable{
    /**
     * 主键ID
     */
    private Integer roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色中文名称
     */
    private String roleZhName;


    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleZhName() {
        return roleZhName;
    }

    public void setRoleZhName(String roleZhName) {
        this.roleZhName = roleZhName;
    }






}
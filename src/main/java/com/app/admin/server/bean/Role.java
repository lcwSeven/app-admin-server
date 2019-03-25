package com.app.admin.server.bean;

/**
 * @author: liucaiwen
 * @date: 2019/3/25 22:38
 */
public class Role {

    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 角色英文名称
     */
    private String roleName;

    /**
     * 角色名称
     */
    private String roleZhName;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
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

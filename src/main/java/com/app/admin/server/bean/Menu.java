package com.app.admin.server.bean;

import java.util.List;

/**
 * @author: liucaiwen
 * @date: 2019/3/25 22:37
 */
public class Menu {

    /**
     * 资源ID
     */
    private Long menuId;
    /**
     * url
     */
    private String url;

    /**
     * 路径
     */
    private String path;
    /**
     * 组件
     */
    private Object component;
    /**
     * 资源名称
     */
    private String name;
    /**
     * 父菜单ID
     */
    private Long parentId;

    /**
     * 子菜单
     */
    private List<Menu> children;
    /**
     * 角色
     */
    private List<Role> roles;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Object getComponent() {
        return component;
    }

    public void setComponent(Object component) {
        this.component = component;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }
}

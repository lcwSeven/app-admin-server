package com.app.admin.server.bean;

import java.util.List;

/**
 * @author: liucaiwen
 * @date: 2019/3/25 22:37
 */
public class AppMenu extends MenuMeta{

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
    private Integer menuParentId;


    private MenuMeta meta;

    private boolean enabled;

    /**
     * 子菜单
     */
    private List<AppMenu> children;
    /**
     * 角色
     */
    private List<AppRole> appRoles;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<AppRole> getAppRoles() {
        return appRoles;
    }

    public void setAppRoles(List<AppRole> appRoles) {
        this.appRoles = appRoles;
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


    public Integer getMenuParentId() {
        return menuParentId;
    }

    public void setMenuParentId(Integer menuParentId) {
        this.menuParentId = menuParentId;
    }

    public MenuMeta getMeta() {
        return meta;
    }

    public void setMeta(MenuMeta meta) {
        this.meta = meta;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<AppMenu> getChildren() {
        return children;
    }

    public void setChildren(List<AppMenu> children) {
        this.children = children;
    }
}

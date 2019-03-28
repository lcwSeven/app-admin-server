package com.app.admin.server.bean;

import java.io.Serializable;

/**
 * @author: liucaiwen
 * @date: 2019/3/27 22:56
 */
public class MenuMeta implements Serializable {
    private boolean keepAlive;
    private boolean requireAuth;

    public boolean isKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(boolean keepAlive) {
        this.keepAlive = keepAlive;
    }

    public boolean isRequireAuth() {
        return requireAuth;
    }

    public void setRequireAuth(boolean requireAuth) {
        this.requireAuth = requireAuth;
    }
}

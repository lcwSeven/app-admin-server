package com.app.admin.server.common;

import com.app.admin.server.bean.AppUser;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author: liucaiwen
 * @date: 2019/3/25 22:26
 */
public class UserUtil {
    public static AppUser getCurrentUser(){
        return (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}

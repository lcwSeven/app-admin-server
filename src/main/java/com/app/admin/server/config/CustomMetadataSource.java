package com.app.admin.server.config;

import com.app.admin.server.bean.AppMenu;
import com.app.admin.server.bean.AppRole;
import com.app.admin.server.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * @author: liucaiwen
 * @date: 2019/3/25 22:33
 */
@Component
public class CustomMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Autowired
    private MenuService menuService;

    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) {
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        List<AppMenu> allMenu = menuService.getAllMenu();
        for (AppMenu menu : allMenu) {
            if (antPathMatcher.match(menu.getUrl(), requestUrl)
                    && menu.getAppRoles().size() > 0) {
                List<AppRole> roles = menu.getAppRoles();
                int size = roles.size();
                String[] values = new String[size];
                for (int i = 0; i < size; i++) {
                    values[i] = roles.get(i).getRoleName();
                }
                return SecurityConfig.createList(values);
            }
        }
        //没有匹配上的资源，都是登录访问
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return FilterInvocation.class.isAssignableFrom(aClass);
    }
}

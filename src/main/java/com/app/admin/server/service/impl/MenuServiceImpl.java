package com.app.admin.server.service.impl;

import com.app.admin.server.bean.AppMenu;
import com.app.admin.server.common.UserUtil;
import com.app.admin.server.dao.AppMenuMapper;
import com.app.admin.server.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: liucaiwen
 * @date: 2019/3/25 23:23
 */
@Service
public class MenuServiceImpl implements MenuService{
    @Autowired
    private AppMenuMapper appMenuMapper;

    @Override
    public List<AppMenu> getAllMenu() {
        return appMenuMapper.getAllMenu();
    }

    @Override
    public List<AppMenu> getMenusByUserId() {
        return appMenuMapper.getMenusByUserId(UserUtil.getCurrentUser().getUserId());
    }
}

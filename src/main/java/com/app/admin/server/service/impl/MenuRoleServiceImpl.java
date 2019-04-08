package com.app.admin.server.service.impl;

import com.app.admin.server.dao.AppMenuRoleMapper;
import com.app.admin.server.service.MenuRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: liucaiwen
 * @date: 2019/4/7 22:38
 */
@Service
@Transactional
public class MenuRoleServiceImpl implements MenuRoleService {

    @Autowired
    private AppMenuRoleMapper appMenuRoleMapper;

    @Override
    public int updateMenuRole(Integer roleId, Integer[] menuIds) {
        appMenuRoleMapper.deleteMenuByRid(roleId);
        if (menuIds.length == 0) {
            return 0;
        }
        return appMenuRoleMapper.addMenu(roleId, menuIds);
    }
}

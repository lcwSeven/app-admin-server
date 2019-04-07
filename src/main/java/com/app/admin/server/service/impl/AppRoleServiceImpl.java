package com.app.admin.server.service.impl;

import com.app.admin.server.bean.AppRole;
import com.app.admin.server.bean.ServerResponse;
import com.app.admin.server.dao.AppRoleMapper;
import com.app.admin.server.service.AppRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: liucaiwen
 * @date: 2019/4/3 22:09
 */
@Service
public class AppRoleServiceImpl implements AppRoleService {
    @Autowired
    private AppRoleMapper appRoleMapper;

    @Override
    public List<AppRole> getAppRoles() {
        return appRoleMapper.appRoles();
    }

    @Override
    public ServerResponse addRole(String roleName, String roleZhName) {

        if (appRoleMapper.addNewRole(roleName, roleZhName) == 1) {
            return ServerResponse.buildBySuccess();
        }
        return ServerResponse.buildByErrorMsg("增加角色失败！");
    }

    @Override
    public ServerResponse deleteRoleById(Integer roleId) {
        if (appRoleMapper.deleteRoleById(roleId) == 1){
            return ServerResponse.buildBySuccess();
        }
        return ServerResponse.buildByErrorMsg("删除角色失败！");
    }
}

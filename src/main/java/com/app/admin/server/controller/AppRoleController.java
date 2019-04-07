package com.app.admin.server.controller;

import com.app.admin.server.bean.AppRole;
import com.app.admin.server.bean.ServerResponse;
import com.app.admin.server.service.AppRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: liucaiwen
 * @date: 2019/4/3 22:10
 */
@RestController
public class AppRoleController {

    @Autowired
    private AppRoleService appRoleService;

    @RequestMapping(value = "/system/roles", method = RequestMethod.GET)
    public ServerResponse getAppRoles() {
        List<AppRole> appRoles = appRoleService.getAppRoles();
        return ServerResponse.buildBySuccess(appRoles);
    }

    @RequestMapping(value = "/system/addRole", method = RequestMethod.POST)
    public ServerResponse addRole(String roleName, String roleZhName) {
        return appRoleService.addRole(roleName, roleZhName);
    }

    @RequestMapping(value = "/system/role/{roleId}", method = RequestMethod.DELETE)
    public ServerResponse deleteRoleById(@PathVariable Integer roleId) {
        return appRoleService.deleteRoleById(roleId);
    }

}

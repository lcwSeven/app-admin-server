package com.app.admin.server.controller;

import com.app.admin.server.bean.AppMenu;
import com.app.admin.server.bean.ServerResponse;
import com.app.admin.server.service.MenuRoleService;
import com.app.admin.server.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: liucaiwen
 * @date: 2019/4/2 23:06
 */
@RestController
public class MenuConfigController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private MenuRoleService menuRoleService;

    @RequestMapping(value = "/system/menus", method = RequestMethod.GET)
    public ServerResponse getSystemMenusByUserId() {
        return ServerResponse.buildBySuccess(menuService.getMenusByUserId());
    }

    @RequestMapping(value = "/system/menuTree/{roleId}", method = RequestMethod.GET)
    public ServerResponse getMenuTreeByRoleId(@PathVariable Integer roleId) {
        Map<String, Object> map = new HashMap<>();
        List<AppMenu> menus = menuService.menuTree();
        map.put("menus", menus);
        List<Integer> selMenuId = menuService.getMenuTreeByRoleId(roleId);
        map.put("selMenuId", selMenuId);
        return ServerResponse.buildBySuccess(map);
    }

    @RequestMapping(value = "/system/updateMenuRole", method = RequestMethod.PUT)
    public ServerResponse updateMenuRole(Integer roleId, Integer[] menuIds) {
        if (menuRoleService.updateMenuRole(roleId, menuIds) == menuIds.length) {
            return ServerResponse.buildBySuccessMsg("更新成功！");
        }
        return ServerResponse.buildByErrorMsg("更新失败!");

    }
}

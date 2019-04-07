package com.app.admin.server.controller;

import com.app.admin.server.bean.ServerResponse;
import com.app.admin.server.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: liucaiwen
 * @date: 2019/4/2 23:06
 */
@RestController
public class MenuConfigController {

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/system/menus", method = RequestMethod.GET)
    public ServerResponse getSystemMenusByUserId() {
        return ServerResponse.buildBySuccess(menuService.getMenusByUserId());
    }
}

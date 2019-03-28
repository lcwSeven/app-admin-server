package com.app.admin.server.controller;

import com.app.admin.server.bean.AppUser;
import com.app.admin.server.common.UserUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author: liucaiwen
 * @date: 2019/3/17 12:27
 */
@RestController
public class UserBaseController {

    @RequestMapping("/user")
    public AppUser getCurrentUser() {
        return UserUtil.getCurrentUser();
    }

}

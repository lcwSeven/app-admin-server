package com.app.admin.server.controller;

import com.app.admin.server.bean.AppUser;
import com.app.admin.server.bean.ServerResponse;
import com.app.admin.server.common.UserUtil;
import com.app.admin.server.constant.ResponseEnum;
import com.app.admin.server.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * 基础控制器
 *
 * @author: liucaiwen
 * @date: 2019/3/17 12:27
 */
@RestController
public class UserBaseController {

    @Autowired
    private UserDetailService userDetailService;



    /**
     * 获取当前用户
     *
     * @return 用户信息
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ServerResponse getCurrentUser() {
        return ServerResponse.buildBySuccess(UserUtil.getCurrentUser());
    }

    /**
     * 未登录
     *
     * @return 返回
     */
    @RequestMapping(value = "/login_p")
    public ServerResponse loginP() {
        return ServerResponse.buildByEnum(ResponseEnum.NEED_LOGIN);
    }

    /**
     * 用户注册
     *
     * @param appUser 用户信息
     * @return 返回
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ServerResponse registerUser(AppUser appUser) {
        return userDetailService.registerUser(appUser);
    }


}

package com.app.admin.server.controller;

import com.app.admin.server.bean.ServerResponse;
import com.app.admin.server.service.UserLoginService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author: liucaiwen
 * @date: 2019/3/17 12:27
 */
@RestController
public class UserLoginController {

    @Autowired
    private UserLoginService userLoginService;

    @PostMapping("/user/login")
    public ServerResponse userLogin(@Param("userName") String userName, @Param("password") String password) {
        return userLoginService.userLogin(userName, password);
    }

}

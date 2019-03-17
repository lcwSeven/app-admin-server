package com.app.admin.server.service.impl;

import com.app.admin.server.bean.AppUser;
import com.app.admin.server.bean.ServerResponse;
import com.app.admin.server.dao.AppUserRepository;
import com.app.admin.server.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: liucaiwen
 * @date: 2019/3/17 13:55
 */
@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private AppUserRepository appUserRepository;


    @Override
    public ServerResponse userLogin(String userName, String password) {

        AppUser appUser = appUserRepository.selectByUserName(userName);
        if (appUser == null) {
            return ServerResponse.buildByErrorMsg("用户不存在！");
        }
        String userPassword = appUser.getUserPassword();
        if (!password.equals(userPassword)) {
            return ServerResponse.buildByErrorMsg("密码错误");
        }
        return ServerResponse.buildBySuccess("登录成功");
    }
}

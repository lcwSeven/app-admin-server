package com.app.admin.server.service.impl;

import com.app.admin.server.bean.ServerResponse;
import com.app.admin.server.dao.AppUserRepository;
import com.app.admin.server.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: liucaiwen
 * @date: 2019/3/17 13:55
 */
@Service
public class UserLoginServiceImpl implements UserLoginService{

//    @Autowired
//    private AppUserRepository appUserRepository;
    @Override
    public ServerResponse userLogin(String userName, String password) {

        return null;
    }
}

package com.app.admin.server.service.impl;

import com.app.admin.server.bean.AppUser;
import com.app.admin.server.bean.ServerResponse;
import com.app.admin.server.constant.ResponseEnum;
import com.app.admin.server.dao.AppUserMapper;
import com.app.admin.server.exception.BusinessException;
import com.app.admin.server.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * @author: liucaiwen
 * @date: 2019/3/17 13:55
 */
@Service
public class UserDetailServiceImpl implements UserDetailService {

    @Autowired
    private AppUserMapper appUserMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        AppUser appUser = appUserMapper.loadUserByUsername(s);
        if (appUser == null) {
            throw new UsernameNotFoundException("用户名不对");
        }
        return appUser;
    }

    @Override
    public ServerResponse registerUser(AppUser appUser) {
        if (!verifyUser(appUser).isSuccess()) {
            return verifyUser(appUser);
        }
        if (appUserMapper.insertAppUser(appUser) == 1) {
            return ServerResponse.buildBySuccess("新增用户成功");
        }
        return ServerResponse.buildByErrorMsg("新增用户失败");
    }

    @Override
    public ServerResponse updateUser(AppUser appUser) {
        if (appUser.getUserId() == null) {
            return ServerResponse.buildByErrorMsg("用户ID不能为空!");
        }
        AppUser dataUser = appUserMapper.loadUserByPrimaryKey(appUser.getUserId());
        if (dataUser == null) {
            return ServerResponse.buildByErrorMsg("更新用户不存在!");
        }

        if (appUserMapper.updateAppUser(appUser) == 1) {
            return ServerResponse.buildBySuccess("更新用户成功！");
        }

        return ServerResponse.buildByErrorMsg("更新用户失败");
    }

    @Override
    public ServerResponse getAllAppUsers() {
        return ServerResponse.buildBySuccess(appUserMapper.getAllAppUsers());
    }

    private ServerResponse verifyUser(AppUser appUser) {
        //获取用户名
        if (appUserMapper.loadUserByUsername(appUser.getUsername()) != null) {
            throw new BusinessException("");
        }
        return ServerResponse.buildBySuccess();
    }

}

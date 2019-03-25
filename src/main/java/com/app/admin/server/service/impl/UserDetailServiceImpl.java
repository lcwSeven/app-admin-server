package com.app.admin.server.service.impl;

import com.app.admin.server.bean.AppUser;
import com.app.admin.server.bean.ServerResponse;
import com.app.admin.server.dao.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



/**
 * @author: liucaiwen
 * @date: 2019/3/17 13:55
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.selectByUserName(s);
        if (appUser == null) {
            throw new UsernameNotFoundException("用户名不对");
        }
        return appUser;
    }
}

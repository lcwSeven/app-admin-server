package com.app.admin.server.service.impl;

import com.app.admin.server.bean.AppDataManager;
import com.app.admin.server.bean.ServerResponse;
import com.app.admin.server.dao.AppDataManagerMapper;
import com.app.admin.server.service.AppDataManagerService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: liucaiwen
 * @date: 2019/4/8 22:54
 */
@Service
public class AppDataManagerServiceImpl implements AppDataManagerService {

    @Autowired
    private AppDataManagerMapper appDataManagerMapper;

    @Override
    public ServerResponse searchAppData(AppDataManager appDataManager, PageInfo<AppDataManager> pageInfo) {
        PageHelper.offsetPage(pageInfo.getStartRow(), pageInfo.getPageSize());
        List<AppDataManager> appDataManagers = appDataManagerMapper.select(appDataManager);
        Map<Object, Object> result = new HashMap<>(1 << 4);
        long totalCount;
        if (appDataManagers instanceof Page) {
            totalCount = ((Page) appDataManagers).getTotal();
        } else {
            totalCount = appDataManagers.size();
        }
        result.put("totalCount", totalCount);
        result.put("list", appDataManagers);
        return ServerResponse.buildBySuccess(result);
    }

    @Override
    public int addAppData(AppDataManager appDataManager) {
        return appDataManagerMapper.insertSelective(appDataManager);
    }

    @Override
    public int updateAppData(AppDataManager appDataManager) {

        return appDataManagerMapper.updateByPrimaryKeySelective(appDataManager);
    }

    @Override
    public int deleteAppData(Integer id) {
        return appDataManagerMapper.deleteByPrimaryKey(id);
    }


}

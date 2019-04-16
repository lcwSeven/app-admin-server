package com.app.admin.server.service;

import com.app.admin.server.bean.AppDataManager;
import com.app.admin.server.bean.ServerResponse;
import com.github.pagehelper.PageInfo;

/**
 * @author: liucaiwen
 * @date: 2019/4/8 22:55
 */
public interface AppDataManagerService {

    /**
     * 分页查询数据
     *
     * @param appDataManager 查询条件
     * @param pageInfo       分页信息
     * @return 返回
     */
    ServerResponse searchAppData(AppDataManager appDataManager, PageInfo<AppDataManager> pageInfo);

    /**
     * 新增数据
     *
     * @param appDataManager 数据
     * @return 返回
     */
    int addAppData(AppDataManager appDataManager);

    /**
     * 更新数据
     *
     * @param appDataManager 数据
     * @return 返回
     */
    int updateAppData(AppDataManager appDataManager);

    /**
     * 通过ID删除数据
     *
     * @param id 主键ID
     * @return 返回
     */
    int deleteAppData(Integer id);
}

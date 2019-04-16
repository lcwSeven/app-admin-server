package com.app.admin.server.dao;

import com.app.admin.server.bean.AppDataManager;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * AppDataManagerDAO继承基类
 *
 * @author caiwenliu
 */
@Repository
public interface AppDataManagerMapper {


    /**
     * 查询
     *
     * @param appDataManager 查询条件
     * @return 返回
     */
    List<AppDataManager> select(AppDataManager appDataManager);

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return 返回
     */
    AppDataManager selectByPrimaryKey(Integer id);

    /**
     * 根据主键删除
     *
     * @param id 主键ID
     * @return 返回
     */
    int deleteByPrimaryKey(Integer id);


    /**
     * 插入数据
     *
     * @param appDataManager 数据
     * @return 返回
     */
    int insertSelective(AppDataManager appDataManager);

    /**
     * 更新数据
     *
     * @param appDataManager 数据
     * @return 返回
     */
    int updateByPrimaryKeySelective(AppDataManager appDataManager);
}
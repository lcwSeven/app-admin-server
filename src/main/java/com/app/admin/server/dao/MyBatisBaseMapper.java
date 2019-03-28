package com.app.admin.server.dao;

import java.io.Serializable;
import java.util.List;


/**
 * DAO公共基类，由MybatisGenerator自动生成请勿修改
 *
 * @param <Model> The Model Class 这里是泛型不是Model类
 * @param <PK>    The Primary Key Class 如果是无主键，则可以用Model来跳过，如果是多主键则是Key类
 * @author liucaiwen
 * @date 2019/03/17
 */

public interface MyBatisBaseMapper<Model, PK extends Serializable> {

    /**
     * 根据主键删除对象
     *
     * @param id 主键id
     * @return 返回
     */
    int deleteByPrimaryKey(PK id);

    /**
     * 插入数据
     *
     * @param record 数据
     * @return 返回
     */
    int insert(Model record);

    int insertSelective(Model record);

    /**
     * 查询数据
     *
     * @param record 查询条件
     * @return 返回
     */
    List<Model> select(Model record);

    Model selectByPrimaryKey(PK id);


    int updateByPrimaryKey(Model record);

    int updateByPrimaryKeySelective(Model record);
}
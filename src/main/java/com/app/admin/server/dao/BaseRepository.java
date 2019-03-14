package com.app.admin.server.dao;

import org.springframework.stereotype.Repository;

import java.lang.invoke.SerializedLambda;
import java.util.List;

/**
 * @author: liucaiwen
 * @date: 2019/3/14 23:16
 */
@Repository
public interface BaseRepository<T, ID> {

    /**
     * 根据条件查询
     *
     * @param o 条件
     * @return 返回数组
     */
    List<T> select(T o);

    /**
     * 根据主键查询
     *
     * @param id 主键ID
     * @return 返回
     */
    T selectByPrimaryKey(ID id);
}

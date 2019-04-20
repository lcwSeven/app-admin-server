package com.app.admin.server.dao;

import com.app.admin.server.bean.AppPicture;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liucaiwen
 * @date 2019/04/17
 * AppPictureDAO继承基类
 */
@Repository
public interface AppPictureMapper {

    /**
     * 查询图片
     *
     * @param appPicture 图片
     * @return 返回
     */
    List<AppPicture> select(AppPicture appPicture);

    /**
     * 根据主键查询
     *
     * @param pictureId 图片ID
     * @return 返回
     */
    AppPicture selectByPrimaryKey(Integer pictureId);

    /**
     * 根据主键删除
     *
     * @param pictureId 主键ID
     * @return 返回
     */
    int deleteByPrimaryKey(Integer pictureId);

    /**
     * 插入数据
     *
     * @param appPicture 数据
     * @return 返回
     */
    int insertSelective(AppPicture appPicture);

    /**
     * 更新数据
     *
     * @param appPicture 数据
     * @return 返回
     */
    int updateByPrimaryKey(AppPicture appPicture);
}
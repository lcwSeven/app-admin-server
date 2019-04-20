package com.app.admin.server.service;

import com.app.admin.server.bean.AppPicture;
import com.app.admin.server.bean.ServerResponse;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author: liucaiwen
 * @date: 2019/4/17 22:31
 */
public interface AppPictureService {

    /**
     * 分页查询图片信息
     *
     * @param appPicture 图片信息
     * @param pageInfo   分页信息
     * @return 返回
     */
    ServerResponse searchAppPicture(AppPicture appPicture, PageInfo<AppPicture> pageInfo);

    /**
     * 新增图片信息
     *
     * @param appPicture 图片信息
     * @return 返回
     */
    int addPictureInfo(AppPicture appPicture);


    /**
     * 更新图片信息
     *
     * @param appPicture 图片信息
     * @return 返回
     */
    int updatePictureInfo(AppPicture appPicture);

    /**
     * 删除图片信息
     *
     * @param pictureId 图片ID
     * @return 返回
     */
    int deletePictureInfo(Integer pictureId);
}

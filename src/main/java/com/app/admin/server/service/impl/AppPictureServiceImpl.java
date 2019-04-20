package com.app.admin.server.service.impl;

import com.app.admin.server.bean.AppPicture;
import com.app.admin.server.bean.ServerResponse;
import com.app.admin.server.dao.AppPictureMapper;
import com.app.admin.server.service.AppPictureService;
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
 * @date: 2019/4/17 22:39
 */
@Service
public class AppPictureServiceImpl implements AppPictureService {

    @Autowired
    private AppPictureMapper appPictureMapper;

    @Override
    public ServerResponse searchAppPicture(AppPicture appPicture, PageInfo<AppPicture> pageInfo) {
        PageHelper.offsetPage(pageInfo.getStartRow(), pageInfo.getPageSize());
        List<AppPicture> appPictures = appPictureMapper.select(appPicture);
        Map<Object, Object> result = new HashMap<>(1 << 4);
        long totalCount;
        if (appPictures instanceof Page) {
            totalCount = ((Page) appPictures).getTotal();
        } else {
            totalCount = appPictures.size();
        }
        result.put("totalCount", totalCount);
        result.put("list", appPictures);
        return ServerResponse.buildBySuccess(result);
    }

    @Override
    public int addPictureInfo(AppPicture appPicture) {
        return appPictureMapper.insertSelective(appPicture);
    }

    @Override
    public int updatePictureInfo(AppPicture appPicture) {
        return appPictureMapper.updateByPrimaryKey(appPicture);
    }

    @Override
    public int deletePictureInfo(Integer pictureId) {
        return appPictureMapper.deleteByPrimaryKey(pictureId);
    }
}

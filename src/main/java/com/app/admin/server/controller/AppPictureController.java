package com.app.admin.server.controller;

import com.app.admin.server.bean.AppDataManager;
import com.app.admin.server.bean.AppPicture;
import com.app.admin.server.bean.ServerResponse;
import com.app.admin.server.service.AppPictureService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: liucaiwen
 * @date: 2019/4/17 22:42
 */
@RestController
public class AppPictureController {

    @Autowired
    private AppPictureService appPictureService;

    @RequestMapping(value = "/app-picture", method = RequestMethod.GET)
    public ServerResponse getPictureInfo(
            @RequestParam(defaultValue = "1") Integer page
            , @RequestParam(defaultValue = "10") Integer size) {

        PageInfo<AppPicture> pageInfo = new PageInfo<>();
        pageInfo.setPageSize(size);
        pageInfo.setStartRow((page - 1) * size);
        return appPictureService.searchAppPicture(null, pageInfo);
    }

    @RequestMapping(value = "/app-picture", method = RequestMethod.POST)
    public ServerResponse addPictureInfo(AppPicture appPicture) {
        if (appPictureService.addPictureInfo(appPicture) == 1) {
            return ServerResponse.buildBySuccessMsg("新增成功！");
        }
        return ServerResponse.buildByErrorMsg("新增失败！");
    }

    @RequestMapping(value = "/app-picture", method = RequestMethod.PUT)
    public ServerResponse updatePictureInfo(AppPicture appPicture) {
        if (appPictureService.updatePictureInfo(appPicture) == 1) {
            return ServerResponse.buildBySuccessMsg("更新成功！");
        }
        return ServerResponse.buildByErrorMsg("更新失败！");
    }

    @RequestMapping(value = "/app-picture/{pictureId}", method = RequestMethod.DELETE)
    public ServerResponse deleteNewAppData(@PathVariable int pictureId) {
        if (appPictureService.deletePictureInfo(pictureId) == 1) {
            return ServerResponse.buildBySuccessMsg("删除成功！");
        }
        return ServerResponse.buildByErrorMsg("删除失败！");
    }
}

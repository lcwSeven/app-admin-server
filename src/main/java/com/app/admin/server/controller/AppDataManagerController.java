package com.app.admin.server.controller;

import com.app.admin.server.bean.AppDataManager;
import com.app.admin.server.bean.ServerResponse;
import com.app.admin.server.service.AppDataManagerService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author: liucaiwen
 * @date: 2019/4/8 22:56
 */
@RestController
public class AppDataManagerController {

    @Autowired
    private AppDataManagerService dataManagerService;

    @RequestMapping(value = "/app-data-manager", method = RequestMethod.GET)
    public ServerResponse getAppData(@RequestParam(defaultValue = "1") Integer page,
                                     @RequestParam(defaultValue = "10") Integer size, String dataOne) {

        PageInfo<AppDataManager> pageInfo = new PageInfo<>();
        pageInfo.setPageSize(size);
        pageInfo.setStartRow((page - 1) * size);
        AppDataManager appDataManager = new AppDataManager();
        appDataManager.setDataOne(dataOne);
        return dataManagerService.searchAppData(appDataManager, pageInfo);

    }

    @RequestMapping(value = "/app-data-manager", method = RequestMethod.POST)
    public ServerResponse addNewAppData(AppDataManager appDataManager) {
        if (dataManagerService.addAppData(appDataManager) == 1) {
            return ServerResponse.buildBySuccessMsg("新增成功！");
        }
        return ServerResponse.buildByErrorMsg("新增失败！");
    }

    @RequestMapping(value = "/app-data-manager", method = RequestMethod.PUT)
    public ServerResponse updateNewAppData(AppDataManager appDataManager) {
        if (dataManagerService.updateAppData(appDataManager) == 1) {
            return ServerResponse.buildBySuccessMsg("更新成功！");
        }
        return ServerResponse.buildByErrorMsg("更新失败！");
    }

    @RequestMapping(value = "/app-data-manager/{id}", method = RequestMethod.DELETE)
    public ServerResponse deleteNewAppData(@PathVariable int id) {
        if (dataManagerService.deleteAppData(id) == 1) {
            return ServerResponse.buildBySuccessMsg("删除成功！");
        }
        return ServerResponse.buildByErrorMsg("删除失败！");
    }

}

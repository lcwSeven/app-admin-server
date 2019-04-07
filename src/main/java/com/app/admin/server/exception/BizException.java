package com.app.admin.server.exception;

import com.app.admin.server.constant.ResponseEnum;

/**
 * @author: liucaiwen
 * @date: 2019/4/2 23:11
 */
public interface BizException {

    ResponseEnum getResponseEnum();
}

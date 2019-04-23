package com.app.admin.server.exception;

import com.app.admin.server.constant.ResponseEnum;

/**
 * @author: liucaiwen
 * @date: 2019/4/1 22:28
 */
public class BusinessException extends RuntimeException {

    public BusinessException(String msg) {
        super(msg);
    }



}

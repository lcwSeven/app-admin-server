package com.app.admin.server.exception;

import com.app.admin.server.bean.ServerResponse;
import com.app.admin.server.constant.ResponseEnum;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * @author: liucaiwen
 * @date: 2019/4/1 22:22
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Throwable.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ServerResponse handlerResponseException(Throwable e) {
        if (e instanceof BusinessException) {
            ResponseEnum responseEnum = ((BusinessException) e).getResponseEnum();
            return ServerResponse.buildByEnum(responseEnum);
        }
        return ServerResponse.buildByErrorMsg(e.getMessage());
    }

}

package com.app.admin.server.exception;

import com.app.admin.server.bean.ServerResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author: liucaiwen
 * @date: 2019/4/1 22:22
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ServerResponse handlerResponseException(Exception e) {
        if (e instanceof MyException) {
            return ServerResponse.buildByErrorMsg(e.getMessage());
        }
        return null;
    }

}

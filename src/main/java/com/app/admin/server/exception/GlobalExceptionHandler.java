package com.app.admin.server.exception;

import com.app.admin.server.bean.ServerResponse;
import com.app.admin.server.constant.ResponseEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Throwable.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ServerResponse handlerResponseException(Throwable e) {
        logger.error("系统异常！", e);
        if (e instanceof BusinessException) {
            ResponseEnum responseEnum = ((BusinessException) e).getResponseEnum();
            return ServerResponse.buildByEnum(responseEnum);
        }
        return ServerResponse.buildByErrorMsg(e.getMessage());
    }

}

package com.app.admin.server.bean;

import com.app.admin.server.constant.ResponseEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author : liucaiwen
 * @date : 2019/3/17 12:30
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServerResponse<T> {

    private String retCode;

    private String retMsg;

    private T data;

    private ServerResponse(String retCode) {
        this.retCode = retCode;
    }

    private ServerResponse(String retCode, String retMsg) {
        this.retCode = retCode;
        this.retMsg = retMsg;
    }

    private ServerResponse(String retCode, T data) {
        this.retCode = retCode;
        this.data = data;
    }

    public ServerResponse(String retCode, String retMsg, T data) {
        this.retCode = retCode;
        this.retMsg = retMsg;
        this.data = data;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return this.retCode.equals(ResponseEnum.SUCCESS.getCode());
    }

    public String getRetCode() {
        return retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public T getData() {
        return data;
    }


    public static <T> ServerResponse<T> buildBySuccess() {
        return new ServerResponse<T>(ResponseEnum.SUCCESS.getCode());
    }

    public static <T> ServerResponse<T> buildBySuccessMsg(String retMsg) {
        return new ServerResponse<T>(ResponseEnum.SUCCESS.getCode(), retMsg);
    }

    public static <T> ServerResponse<T> buildBySuccess(T data) {
        return new ServerResponse<T>(ResponseEnum.SUCCESS.getCode(),ResponseEnum.SUCCESS.getMsg(), data);
    }

    public static <T> ServerResponse<T> buildBySuccess(String retMsg, T data) {
        return new ServerResponse<T>(ResponseEnum.SUCCESS.getCode(), retMsg, data);
    }

    public static <T> ServerResponse<T> buildByError() {
        return new ServerResponse<T>(ResponseEnum.ERROR.getCode());
    }

    public static <T> ServerResponse<T> buildByErrorMsg(String retMsg) {
        return new ServerResponse<T>(ResponseEnum.ERROR.getCode(), retMsg);
    }

    public static <T> ServerResponse<T> buildByEnum(ResponseEnum responseEnum) {
        return new ServerResponse<T>(responseEnum.getCode(), responseEnum.getMsg());
    }
}

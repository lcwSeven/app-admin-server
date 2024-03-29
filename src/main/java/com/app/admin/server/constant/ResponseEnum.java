package com.app.admin.server.constant;

/**
 * @author: liucaiwen
 * @date: 2019/3/17 12:34
 */
public enum ResponseEnum {

    SUCCESS("00000", "SUCCESS"),

    ERROR("00001","ERROR"),

    NEET_LOGIN("00002", "未登录");


    private String code;

    private String msg;

    ResponseEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

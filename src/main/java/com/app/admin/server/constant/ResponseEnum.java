package com.app.admin.server.constant;

/**
 * @author: liucaiwen
 * @date: 2019/3/17 12:34
 */
public enum ResponseEnum {

    SUCCESS("00000", "success"),

    ERROR("00001", "error"),

    NEED_LOGIN("need_login", "未登录");


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

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

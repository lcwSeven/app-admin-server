package com.app.admin.server.bean;

import java.sql.Timestamp;

/**
 * @author liucaiwen
 * @date 2019/03/11
 */
public class User {

    /**
     * 用户唯一ID
     */
    private String userId;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户密码
     */
     private String userPassword;

    /**
     * 用户邮箱
     */
    private String userMail;

    /**
     * 用户手机
     */
    private String userPhone;

    /**
     * 用户创建时间
     */
    private Timestamp userCreateTime;

    /**
     *  用户更新时间
     */
    private Timestamp userUpdateTime;

    /**
     * 用户更新人
     */
    private String userUpdateBy;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Timestamp getUserCreateTime() {
        return userCreateTime;
    }

    public void setUserCreateTime(Timestamp userCreateTime) {
        this.userCreateTime = userCreateTime;
    }

    public Timestamp getUserUpdateTime() {
        return userUpdateTime;
    }

    public void setUserUpdateTime(Timestamp userUpdateTime) {
        this.userUpdateTime = userUpdateTime;
    }

    public String getUserUpdateBy() {
        return userUpdateBy;
    }

    public void setUserUpdateBy(String userUpdateBy) {
        this.userUpdateBy = userUpdateBy;
    }
}

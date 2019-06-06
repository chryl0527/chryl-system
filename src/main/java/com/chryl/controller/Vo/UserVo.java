package com.chryl.controller.Vo;

/**
 * Created By Chr on 2019/5/29.
 */
public class UserVo {
    /**
     * 用户唯一id
     */
    private String userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户手机
     */
    private String userPhone;

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

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}

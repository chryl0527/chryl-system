package com.chryl.po;

import java.io.Serializable;

public class UserInfo implements Serializable {
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

    private static final long serialVersionUID = 1L;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", userName=").append(userName);
        sb.append(", userPhone=").append(userPhone);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public UserInfo() {
    }

    public UserInfo(String userId, String userName, String userPhone) {
        this.userId = userId;
        this.userName = userName;
        this.userPhone = userPhone;
    }
}
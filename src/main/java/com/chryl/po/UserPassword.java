package com.chryl.po;

import java.io.Serializable;

public class UserPassword implements Serializable {
    /**
     * 用户唯一id
     */
    private String userId;
    /**
     * 用户加密密码
     */
    private String encryptPassword;

    private static final long serialVersionUID = 1L;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getEncryptPassword() {
        return encryptPassword;
    }

    public void setEncryptPassword(String encryptPassword) {
        this.encryptPassword = encryptPassword == null ? null : encryptPassword.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", encryptPassword=").append(encryptPassword);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public UserPassword(String userId, String encryptPassword) {
        this.userId = userId;
        this.encryptPassword = encryptPassword;
    }

    public UserPassword() {
    }
}
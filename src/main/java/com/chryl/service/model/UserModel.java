package com.chryl.service.model;

import com.chryl.po.UserInfo;

import java.io.Serializable;

/**
 * Created By Chr on 2019/5/28.
 */
public class UserModel extends UserInfo implements Serializable {

    private static final long serialVersionUID = -3185228990551902365L;
    private String userInfoId;//userId

    private String encryptPassword;//userEncryptPassword

    public String getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(String userInfoId) {
        this.userInfoId = userInfoId;
    }

    public String getEncryptPassword() {
        return encryptPassword;
    }

    public void setEncryptPassword(String encryptPassword) {
        this.encryptPassword = encryptPassword;
    }
}

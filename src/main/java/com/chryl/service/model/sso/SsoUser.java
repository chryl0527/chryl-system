package com.chryl.service.model.sso;

import java.io.Serializable;

/**
 * 验证登陆
 * <p>
 * Created By Chr on 2019/7/13.
 */
public class SsoUser implements Serializable {
    private static final long serialVersionUID = -6992058076054999516L;

    private String userId;
    private String userName;

    //过期时间
    private int expireMinute;

    //刷新时间
    private long expireFreshTime;

    public SsoUser() {
    }

    public SsoUser(String userId, String userName, int expireMinute, long expireFreshTime) {
        this.userId = userId;
        this.userName = userName;
        this.expireMinute = expireMinute;
        this.expireFreshTime = expireFreshTime;
    }

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

    public int getExpireMinute() {
        return expireMinute;
    }

    public void setExpireMinute(int expireMinute) {
        this.expireMinute = expireMinute;
    }

    public long getExpireFreshTime() {
        return expireFreshTime;
    }

    public void setExpireFreshTime(long expireFreshTime) {
        this.expireFreshTime = expireFreshTime;
    }
}

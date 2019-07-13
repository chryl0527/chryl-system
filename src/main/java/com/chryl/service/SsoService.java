package com.chryl.service;

import com.chryl.service.model.UserModel;
import com.chryl.service.model.sso.SsoUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created By Chr on 2019/7/13.
 */
public interface SsoService {
    /**
     * @param request
     * @param response
     * @param userModel 登陆suc,之后返回的userModel存入redis
     */
    void doSso(HttpServletRequest request, HttpServletResponse response, UserModel userModel);

    /**
     * 验证是否不是第一次登陆
     *
     * @param request
     * @param response
     * @param cookieValue
     * @return
     */
    SsoUser loginCheck(HttpServletRequest request, HttpServletResponse response, String cookieValue);
}

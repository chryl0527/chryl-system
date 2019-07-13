package com.chryl.service;

import com.chryl.response.error.ResponseException;
import com.chryl.service.model.UserModel;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created By Chr on 2019/5/28.
 */
public interface UserService {


    /**
     * 注册用户
     *
     * @param userId
     * @param userName
     * @param userPassword
     * @param userPhone
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     * @throws ResponseException
     */
    void register(String userId, String userName, String userPassword, String userPhone) throws UnsupportedEncodingException, NoSuchAlgorithmException, ResponseException;

    /**
     * 登录验证
     *
     * @param userName
     * @param userPassword 前端输入的密码
     * @return
     * @throws ResponseException
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    UserModel validateLogin(String userName, String userPassword) throws ResponseException, UnsupportedEncodingException, NoSuchAlgorithmException;

    /**
     * 根据userId
     *
     * @param userId
     * @return
     */
    UserModel selectUserModelByUserId(String userId);
}

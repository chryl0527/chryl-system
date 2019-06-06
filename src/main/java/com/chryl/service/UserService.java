package com.chryl.service;

import com.chryl.response.error.ResponseException;
import com.chryl.service.model.UserModel;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created By Chr on 2019/5/28.
 */
public interface UserService {


    void register(String userId, String userName, String userPassword, String userPhone) throws UnsupportedEncodingException, NoSuchAlgorithmException, ResponseException;

    UserModel validateLogin(String userName, String userPassword) throws ResponseException, UnsupportedEncodingException, NoSuchAlgorithmException;
}

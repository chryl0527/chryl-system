package com.chryl.controller;

import com.chryl.response.ReturnResult;
import com.chryl.response.error.BaseController;
import com.chryl.response.error.EnumError;
import com.chryl.response.error.ResponseException;
import com.chryl.service.SsoService;
import com.chryl.service.UserService;
import com.chryl.service.model.UserModel;
import com.chryl.service.model.sso.SsoConf;
import com.chryl.service.model.sso.SsoUser;
import com.chryl.utils.CookieUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created By Chr on 2019/5/28.
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;
    @Autowired
    private SsoService ssoService;

    @RequestMapping(value = "/register/{userName}/{userPassword}/{userPhone}"/*, method = RequestMethod.POST*/)
    public ReturnResult register(@PathVariable("userName") String userName,//
                                 @PathVariable("userPassword") String userPassword,//
                                 @PathVariable("userPhone") String userPhone) throws UnsupportedEncodingException, NoSuchAlgorithmException, ResponseException {


        userService.register(null, userName, userPassword, userPhone);
        //
//        return ReturnResult.create(HttpStatus.CREATED);
        return ReturnResult.create(null);
    }

    //第一次登陆
    @RequestMapping(value = "/login/{userName}/{userPassword}"/*, method = RequestMethod.PUT*/)
    public ReturnResult login(@PathVariable("userName") String userName,//
                              @PathVariable("userPassword") String userPassword,//
                              HttpServletResponse response,//
                              HttpServletRequest request) throws ResponseException, UnsupportedEncodingException, NoSuchAlgorithmException {
        //入参校验
        if (/*StringUtils.isEmpty(userName)*/userName == null || userName.trim().length() == 0) {
            throw new ResponseException(EnumError.PARAMETER_VALIDATION_ERROR);
        }
        if (StringUtils.isEmpty(userPassword)) {
            throw new ResponseException(EnumError.PARAMETER_VALIDATION_ERROR);
        }
        //用户登录流程，校验用户登录是否合法
        UserModel userModel = userService.validateLogin(userName, userPassword);
        //登陆校验成功,doSso
        ssoService.doSso(request, response, userModel);

        return ReturnResult.create(userModel);
    }

    //验证是否第二次登陆
    @RequestMapping("/loginCheck")
    public ReturnResult loginCheck(HttpServletRequest request,//
                                   HttpServletResponse response) {
        String cookieValue = CookieUtil.getCookieValue(request, SsoConf.SSO_COOKIE_NAME, true);
        if (cookieValue == null) {
            //重新返回登录页面
            ReturnResult.create(null);
        }
        //验证redis
        SsoUser ssoUser = ssoService.loginCheck(request, response, cookieValue);
        if (ssoUser == null) {
            //重新返回登录页面
            ReturnResult.create(null);
        }
        //第二次登陆且身份未过期,免登陆
        UserModel userModel = userService.selectUserModelByUserId(ssoUser.getUserId());
        return ReturnResult.create(userModel);
    }

//    @RequestMapping("/logout/{userId}")
//    public ReturnResult logout(HttpServletRequest request, HttpServletResponse response) {
//        ssoService.logout(request, response);
//        return ReturnResult.create(null);
//    }

}

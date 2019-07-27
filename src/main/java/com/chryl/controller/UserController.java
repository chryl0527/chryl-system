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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created By Chr on 2019/5/28.
 */
@Api(value = "user用户信息", description = "user用户注册/检查首次登陆/登录")
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;
    @Autowired
    private SsoService ssoService;

    @ApiOperation(value = "用户注册接口", notes = "用户名,密码,手机号")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "userName", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "path", name = "userPassword", value = "密码", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "path", name = "userPhone", value = "手机号", required = true, dataType = "String")
    })
    @RequestMapping(value = "/register/{userName}/{userPassword}/{userPhone}", method = RequestMethod.POST)
    public ReturnResult register(@PathVariable("userName") String userName,//
                                 @PathVariable("userPassword") String userPassword,//
                                 @PathVariable("userPhone") String userPhone) throws UnsupportedEncodingException, NoSuchAlgorithmException, ResponseException {


        userService.register(null, userName, userPassword, userPhone);
        //
        return ReturnResult.create(HttpStatus.CREATED);
//        return ReturnResult.create(null);
    }

    //第一次登陆
    @ApiOperation(value = "用户登录界面接口", notes = "用户名,密码")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "userName", value = "用户名", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "path", name = "userPassword", value = "密码", required = true, dataType = "String")
    })
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
    @ApiOperation(value = "用户登录验证", notes = "从未登录,跳转到登陆页,第二次登陆使用缓存查询")
    @GetMapping("/loginCheck")
    public ReturnResult loginCheck(HttpServletRequest request,//
                                   HttpServletResponse response) {
        String cookieValue = CookieUtil.getCookieValue(request, SsoConf.SSO_COOKIE_NAME, true);
        if (cookieValue == null) {//no cookie无法验证信息
            //重新返回登录页面
            ReturnResult.create(null);
        }
        //验证redis,更新redis,cookie
        SsoUser ssoUser = ssoService.loginCheck(request, response, cookieValue);
        if (ssoUser == null) {//redis为null,查询db
            String userId = splitInfix(cookieValue);
            UserModel userModel = userService.selectUserModelByUserId(userId);
            if (userModel == null) {//db无数据
                //重新返回登录页面
                return ReturnResult.create(null);
            }
            //sso
            ssoService.doSso(request, response, userModel);
            SsoUser ssoUser1 = convertUserModelFromSsoUser(userModel);
            return ReturnResult.create(ssoUser1);
        }
        //第二次登陆且cookie,redis身份未过期,免登陆
        UserModel userModel = userService.selectUserModelByUserId(ssoUser.getUserId());
        return ReturnResult.create(userModel);
    }

    //    @RequestMapping("/logout/{userId}")
//    public ReturnResult logout(HttpServletRequest request, HttpServletResponse response) {
//        ssoService.logout(request, response);
//        return ReturnResult.create(null);
//    }

    //测试restful
    @PostMapping("/testp/{id}/{name}")
    public ReturnResult show(@PathVariable String id, @PathVariable String name) {

        String str = id + "--" + name;
        return ReturnResult.create(str);
    }



    //
    private static String splitInfix(String cookieValue) {
        return cookieValue.split("#")[1];

    }

    private SsoUser convertUserModelFromSsoUser(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        SsoUser ssoUser = new SsoUser();
        ssoUser.setUserId(userModel.getUserId());
        ssoUser.setUserName(userModel.getUserName());
        ssoUser.setExpireMinute(SsoConf.REDIS_EXPIRE_MINUTE);
        ssoUser.setExpireFreshTime(System.currentTimeMillis());
        return ssoUser;
    }
}

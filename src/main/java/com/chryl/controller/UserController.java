package com.chryl.controller;

import com.chryl.response.ReturnResult;
import com.chryl.response.error.BaseController;
import com.chryl.response.error.EnumError;
import com.chryl.response.error.ResponseException;
import com.chryl.service.UserService;
import com.chryl.service.model.UserModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
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

    @RequestMapping(value = "/register/{userName}/{userPassword}/{userPhone}"/*, method = RequestMethod.POST*/)
    public ReturnResult register(@PathVariable("userName") String userName,//
                                 @PathVariable("userPassword") String userPassword,//
                                 @PathVariable("userPhone") String userPhone) throws UnsupportedEncodingException, NoSuchAlgorithmException, ResponseException {


        userService.register(null, userName, userPassword, userPhone);

        return ReturnResult.create(null);
    }

    @RequestMapping(value = "/login/{userName}/{userPassword}"/*, method = RequestMethod.PUT*/)
    public ReturnResult login(@PathVariable("userName") String userName,//
                              @PathVariable("userPassword") String userPassword,//
                              HttpSession session) throws ResponseException, UnsupportedEncodingException, NoSuchAlgorithmException {
        //入参校验
        if (/*StringUtils.isEmpty(userName)*/userName == null || userName.trim().length() == 0) {
            throw new ResponseException(EnumError.PARAMETER_VALIDATION_ERROR);
        }
        if (StringUtils.isEmpty(userPassword)) {
            throw new ResponseException(EnumError.PARAMETER_VALIDATION_ERROR);
        }
        //用户登录流程，校验用户登录是否合法
        UserModel userModel = userService.validateLogin(userName, userPassword);

        //存入session
//        session.setAttribute("IS_LOGIN_" + userName, true);
//        session.setAttribute("USER_LOGIN_" + userName, userModel);
//        return ReturnResult.create(userModel);


        return ReturnResult.create(userModel);

    }

//    @RequestMapping("/logout/{userId}")
//    public ReturnResult logout(HttpServletRequest request, HttpServletResponse response) {
//        ssoService.logout(request, response);
//        return ReturnResult.create(null);
//    }

}

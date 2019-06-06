package com.chryl.service.impl;

import com.chryl.mapper.UserInfoMapper;
import com.chryl.mapper.UserPasswordMapper;
import com.chryl.po.UserInfo;
import com.chryl.po.UserInfoExample;
import com.chryl.po.UserPassword;
import com.chryl.response.error.EnumError;
import com.chryl.response.error.ResponseException;
import com.chryl.service.UserService;
import com.chryl.service.model.UserModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;

/**
 * Created By Chr on 2019/5/28.
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private UserPasswordMapper userPasswordMapper;

    @Override
    public void register(String userId, String userName, String userPassword, String userPhone) throws UnsupportedEncodingException, NoSuchAlgorithmException, ResponseException {
        if (StringUtils.isEmpty(userName)
                || userPassword == null //
                || userPhone == null) {
            throw new ResponseException(EnumError.PARAMETER_VALIDATION_ERROR);
        }
        UserInfoExample example = new UserInfoExample();
        UserInfoExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(userName);
        List<UserInfo> users = userInfoMapper.selectByExample(example);

        if (users.size() != 0) {
//            return ReturnResult.create("用户名已存在");
            throw new ResponseException(EnumError.USERNAME__EXISTS);
        } else {
            List<String> stringList = userInfoMapper.selectUserPhone();

            for (String s : stringList) {
                if (StringUtils.equals(userPhone, s)) {
                    throw new ResponseException(EnumError.PHONE__EXISTS);
                }
            }

            userId = UUID.randomUUID().toString().replaceAll("-", "");
            UserInfo user = new UserInfo(userId, userName, userPhone);
            String encryptPassword = EncodeByMD5(userPassword);
            UserPassword userPasswordPo = new UserPassword(user.getUserId(), encryptPassword);

            userInfoMapper.insertSelective(user);
            userPasswordMapper.insertSelective(userPasswordPo);
        }

    }

    @Override
    public UserModel validateLogin(String userName, String userPassword) throws ResponseException, UnsupportedEncodingException, NoSuchAlgorithmException {

        UserInfo userInfo = userInfoMapper.selectByUserName(userName);
        if (userInfo == null) {
            throw new ResponseException(EnumError.USER_LOGIN_FAIL);
        }
        UserPassword userPasswordPo = userPasswordMapper.selectByPrimaryKey(userInfo.getUserId());
        String encryptPassword = EncodeByMD5(userPassword);
        //对比用户信息的加密密码和用户输入密码一致:lang3
        if (!StringUtils.equals(encryptPassword, userPasswordPo.getEncryptPassword())) {
            throw new ResponseException(EnumError.USER_LOGIN_FAIL);
        }
        UserModel userModel = convertFromModelByPo(userInfo, userPasswordPo);


        return userModel;
    }

    private UserModel convertFromModelByPo(UserInfo userInfo, UserPassword userPasswordPo) {
        if (userInfo == null | userPasswordPo == null) {
            return null;
        }
        UserModel userModel = new UserModel();

        BeanUtils.copyProperties(userInfo, userModel);
        if (userPasswordPo != null) {
            userModel.setUserInfoId(userInfo.getUserId());
            userModel.setEncryptPassword(userPasswordPo.getEncryptPassword());
        }
        return userModel;
    }

    //手动设置密码加密算法
    private String EncodeByMD5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64Encoder = new BASE64Encoder();
        //加密字符串
        String newStr = base64Encoder.encode(md5.digest(str.getBytes("utf-8")));
        return newStr;
    }
}

package com.chryl.response.error;

/**
 * Created By Chr on 2019/5/28.
 */

/**
 * 枚举异常错误集
 */
public enum EnumError implements CommonError {

    // 1 开头为通用错误类型：通用错误可以根据业务需求修改，比如一些入参没传需要定义很多错误码，只要定义一个不合法类型，只去改动errorMessage即可
    PARAMETER_VALIDATION_ERROR(10000, "参数不合法"),
    UNKNOW_ERROR(00001, "其他错误或未知错误"),

    // 2 开头为用户信息相关错误
    USER_NOT_EXISTS(20000, "用户不存在"),
    USER_CANCLE(20001, "用户已注销"),
    USER_LOGIN_FAIL(20002, "账号或者密码不正确"),
    USER_NOT_LOGIN(20003, "用户暂未登陆"),
    USERNAME__EXISTS(20004, "用户名已存在"),
    PHONE__EXISTS(20005, "手机号已被注册"),


    //3 开头为设备信息相关错误
    SB__NOT_EXIST(30000, "没有该设备id"),
    SB__DELETE_CANCLE(30001, "删除失败,可能不存在"),
    SB__UPDATE_CANCLE(30002, "更新设备失败"),
    SB__EXISTS(30004, "设备id已注册"),


    //4 开头为存储相关错误
    SSO_CANCLE(4000, "存储redis失败"),

    //
    ;


    EnumError(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    //也可以是String类型的errorCode
    private int errorCode;
    private String errorMessage;

    @Override
    public int getErrorCode() {
        return this.errorCode;
    }

    @Override
    public String getErrorMessage() {
        return this.errorMessage;
    }

    //错误码改动信息
    @Override
    public CommonError setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }
}

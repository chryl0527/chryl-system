package com.chryl.response.error;

/**
 * Created By Chr on 2019/5/28.
 */

/**
 * 统一管理错误码
 */
//设计模式：包装器业务异常类实现
public class ResponseException extends Exception implements CommonError {

    //强关联-Enum
    private CommonError commonError;

    //直接接收EnumError的传参，用于构造异常
    public ResponseException(CommonError commonError) {
        super();
        this.commonError = commonError;
    }

    //接收自定义errorMessage的方式构造异常信息
    public ResponseException(CommonError commonError, String errorMessage) {
        super();
        this.commonError = commonError;
        this.commonError.setErrorMessage(errorMessage);
    }

    @Override
    public int getErrorCode() {
        return this.commonError.getErrorCode();
    }

    @Override
    public String getErrorMessage() {
        return this.commonError.getErrorMessage();
    }

    @Override
    public CommonError setErrorMessage(String errorMessage) {
        this.commonError.setErrorMessage(errorMessage);
        return this;
    }
}

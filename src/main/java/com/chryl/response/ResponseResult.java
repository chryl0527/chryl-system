package com.chryl.response;

import java.io.Serializable;

/**
 * Created By Chr on 2019/1/2/0002.
 */
public class ResponseResult implements Serializable {

    private static final long serialVersionUID = 1265636617949435002L;

    private Integer status;
    private String message;
    private Object data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResponseResult(Object data) {
        this.data = data;
        this.status = 200;
        this.message = "Success";
    }

    public ResponseResult(Integer status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    /**
     * 返回成功
     */
    //无返回数据
    public static ResponseResult ok() {
        return new ResponseResult(null);
    }

    //有返回数据
    public static ResponseResult ok(Object data) {
        return new ResponseResult(200, "Success", data);
    }

    //自定义返回数据
    public static ResponseResult ok(Integer status, String message, Object data) {
        return new ResponseResult(status, message, data);
    }

    /**
     * 返回失败
     */
    //无返回数据
    public static ResponseResult fail(Integer status, String message) {
        return new ResponseResult(status, message, null);
    }

    //有返回数据
    public static ResponseResult fail(Object data) {
        return new ResponseResult(500, "Error", data);
    }

    //自定义返回数据
    public static ResponseResult fail(Integer status, String message, Object data) {
        return new ResponseResult(status, message, data);
    }

    /**
     * 自定义返回数据
     */
    public static ResponseResult build(Integer status, String message, Object data) {
        return new ResponseResult(status, message, data);
    }

    /**
     * 自定义不返回数据
     */
    public static ResponseResult build(Integer status, String message) {
        return new ResponseResult(status, message, null);
    }
}

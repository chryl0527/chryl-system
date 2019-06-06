package com.chryl.response;

/**
 * Created by chr on 2018/12/30/0030.
 */

import java.io.Serializable;

/**
 * 统一数据返回处理
 * <p>
 * 只返回String-status和Object-data
 */
public class ReturnResult implements Serializable {

    private static final long serialVersionUID = 5649706393360680653L;

    //返回前端的结果，success，fail
    private String status;
    //若返回success，则返回json的data
    //若返回fail，则使用公用的错误码格式
    private Object data;

    //通用的创建方法，上面的返回成功的，下面是自定义返回的
    public static ReturnResult create(Object data) {
        return ReturnResult.create(data, "success");
    }

    public static ReturnResult create(Object data, String status) {
        ReturnResult type = new ReturnResult();
        type.setData(data);
        type.setStatus(status);
        return type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

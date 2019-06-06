package com.chryl.response.error;

import com.chryl.response.ReturnResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created By Chr on 2019/5/28.
 */
public class BaseController {

    //定义ExceptionHandler解决未被Controller层吸收的Exception
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Object handlerException(HttpServletRequest request, Exception ex) {
        Map<String, Object> responseData = new HashMap<>();
        if (ex instanceof ResponseException) {
            ResponseException responseException = (ResponseException) ex;
            responseData.put("errorCode", responseException.getErrorCode());
            responseData.put("errorMessage", responseException.getErrorMessage());
        } else {
            responseData.put("errorCode", EnumError.UNKNOW_ERROR.getErrorCode());
            responseData.put("errorMessage", EnumError.UNKNOW_ERROR.getErrorMessage());
        }
        //打印错误信息
        ex.printStackTrace();
        return ReturnResult.create(responseData, "fail");

    }
}

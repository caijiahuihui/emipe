package com.caicai.emipe.controller;

import com.caicai.emipe.exception.ControllerException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author caicai
 * @create 2021/6/10
 */
@ControllerAdvice
public class ExceptionController {

    @ResponseBody // 返回的都是JSON数据类型
    @ExceptionHandler(Exception.class)
    public Map<String, String> handleException(Exception e) {
        Map<String, String> errorBody = new HashMap<>();
        if (e instanceof ControllerException) {
            errorBody.put("status", ((ControllerException) e).getCode());
        } else {
            errorBody.put("status", "500");
        }
        errorBody.put("message", e.getMessage());
        return errorBody;
    }

}

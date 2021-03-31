package com.yangjun.shiro.filter;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yangjun6
 * @date 2021-03-31 17:34
 */
@ControllerAdvice
public class MyExceptionHander {
    @ExceptionHandler
    @ResponseBody
    public String ErrorHandler(AuthorizationException e) {
        return "没有通过权限验证！";
    }


}

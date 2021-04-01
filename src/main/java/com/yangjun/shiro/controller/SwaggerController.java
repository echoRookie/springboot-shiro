package com.yangjun.shiro.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangjun6
 * @date 2021-04-01 22:06
 */
@RestController
@Api
public class SwaggerController {
    @ApiOperation(value ="测试")
    @GetMapping(value = "/hello")
    public String hello(){
        return "hello";
    }
}

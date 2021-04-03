package com.yangjun.shiro.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author yangjun6
 * @date 2021-04-01 22:06
 */
@RestController
@Api
public class SwaggerController {
    @Async
    @ApiOperation(value ="测试")
    @GetMapping(value = "/hello")
    public void hello(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hello");;
    }
}

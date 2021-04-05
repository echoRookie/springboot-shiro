package com.yangjun.shiro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangjun6
 * @date 2021-04-05 22:19
 */
@RestController
public class RedisController {
    @Autowired
    private RedisTemplate redisTemplate;
    @GetMapping("/redis/set")
    public void setKey(){
        redisTemplate.opsForValue().set("test", "test");
    }
}

package com.yangjun.shiro.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author yangjun6
 * @date 2021-04-04 16:37
 */
@Service
public class ScheduleController {
    @Scheduled(cron = "0 42 16 * * ?")
    public void hello(){
        System.out.println("定时任务测试");
    }
}

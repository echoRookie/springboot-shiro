package com.yangjun.shiro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangjun6
 * @date 2021-04-03 22:27
 */
@RestController
public class MailController {
    @Autowired
    JavaMailSenderImpl javaMailSender;
    @GetMapping("/sendMail")
    public void send(){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject("测试");
        mailMessage.setTo("1171349468@qq.com");
        mailMessage.setFrom("1171349468@qq.com");
        mailMessage.setText("这是测试内容");
        javaMailSender.send(mailMessage);
        System.out.println("发送成功");
    }
}

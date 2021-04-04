package com.yangjun.shiro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

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
    @GetMapping("/sendMimeMail")
    public void sendMime(){
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setSubject("测试");
            helper.setTo("1171349468@qq.com");
            helper.setFrom("1171349468@qq.com");
            helper.setText("这是测试内容");
            helper.addAttachment("酒店发票1.jpg", new File("D:\\MyData\\yangjun6.CN\\Desktop\\工作\\12月份差旅报销\\酒店发票1.jpg"));
            javaMailSender.send(message);
            System.out.println("发送成功");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        System.out.println("发送成功");
    }
}

package com.yangjun.shiro.controller;

import com.yangjun.shiro.bean.User;
import com.yangjun.shiro.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yangjun6
 * @date 2021-03-31 16:26
 */
@RestController
public class LoginController {
    @Resource
    private LoginService loginService;

    @GetMapping("/login")
    public String login(User user){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        try {
            subject.login(usernamePasswordToken);
        }catch (UnknownAccountException e) {

            return "用户名不存在！";
        } catch (AuthenticationException e) {

            return "账号或密码错误！";
        } catch (AuthorizationException e) {

            return "没有权限";
        }

        return "login success";
    }
    @GetMapping("/index")
    public String idnex(){
        return "index success";
    }
    @RequiresPermissions("menu1")
    @GetMapping("/log")
    public String log(){
        return "index success";
    }

    @RequiresPermissions("menu2")
    @GetMapping("/main")
    public String main(){
        return "index success";
    }
    @RequiresRoles("admin")
    @GetMapping("/test")
    public String test(){
        return "test success";
    }
}

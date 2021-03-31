package com.yangjun.shiro.shiro;

import com.yangjun.shiro.bean.Permission;
import com.yangjun.shiro.bean.Role;
import com.yangjun.shiro.bean.User;
import com.yangjun.shiro.service.LoginService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yangjun6
 * @date 2021-03-31 15:19
 */
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private LoginService loginService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //授权方法
        String name = (String) principalCollection.getPrimaryPrincipal();
        User user = loginService.getUserByName(name);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//        for (Role role: user.getRoleList()) {
//            simpleAuthorizationInfo.addRole(role.getRoleName());
//            for (Permission permission: role.getPermissionList()) {
//                simpleAuthorizationInfo.addStringPermission(permission.getPermissionName());
//            }
//        }

        simpleAuthorizationInfo.addStringPermission("index");
        simpleAuthorizationInfo.addRole("admin");
        return  simpleAuthorizationInfo;

    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
       //验证方法
        String name = authenticationToken.getPrincipal().toString();
        User user = loginService.getUserByName(name);
        if (user == null) {
            //这里返回后会报出对应异常
            return null;
        } else {
            //这里验证authenticationToken和simpleAuthenticationInfo的信息
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name, user.getPassword().toString(), getName());
            return simpleAuthenticationInfo;
        }
    }
}

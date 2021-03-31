package com.yangjun.shiro.service.impl;

import com.yangjun.shiro.bean.Permission;
import com.yangjun.shiro.bean.Role;
import com.yangjun.shiro.bean.User;
import com.yangjun.shiro.service.LoginService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangjun6
 * @date 2021-03-31 14:48
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public User getUserByName(String name) {
        //模拟数据库数据
        Permission permissionMenu1 = new Permission("1", "menu1");
        Permission permissionMenu2 = new Permission("2", "menu2");
        //管理员权限
        List<Permission> adminList = new ArrayList<>();
        adminList.add(permissionMenu1);
        adminList.add(permissionMenu2);
        //用户权限
        List<Permission> userList = new ArrayList<>();
        userList.add(permissionMenu1);

        Role adminRole = new Role("1","admin", adminList);
        Role userRole = new Role("1","user", userList);
        //管理员角色
        List<Role> adminRoleList = new ArrayList<>();
        adminRoleList.add(adminRole);
        //用户角色
        List<Role> userRoleList = new ArrayList<>();
        userRoleList.add(userRole);
        User user = new User("1", "test", "1234", userRoleList);
        Map<String, User> map = new HashMap<>();
        map.put("test", user);
        return map.get(name);
    }
}

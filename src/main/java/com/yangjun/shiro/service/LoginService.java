package com.yangjun.shiro.service;

import com.yangjun.shiro.bean.User;

/**
 * @author yangjun6
 * @date 2021-03-31 14:47
 */
public interface LoginService {
    User getUserByName(String name);
}

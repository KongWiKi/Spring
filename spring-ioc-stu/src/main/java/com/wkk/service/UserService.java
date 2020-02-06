package com.wkk.service;

import com.wkk.dao.UserDao;

/**
 * @Time: 20-2-6上午10:55
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public interface UserService {
    void getUser();
    void setUserDao(UserDao userDao);
}

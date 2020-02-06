package com.wkk.service.impl;

import com.wkk.dao.UserDao;
import com.wkk.service.UserService;

/**
 * @Time: 20-2-6上午10:55
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    //     利用set进行动态实现值的注入
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void getUser() {
    //      System.out.println("UserService实现类: 对用户数据的逻辑操作(用户角度)");
        userDao.getUser();
    }

}

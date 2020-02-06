package com.wkk.service.impl;

import com.wkk.dao.impl.UserDaoImpl;
import com.wkk.dao.impl.UserDaoMysqlImpl;
import com.wkk.dao.impl.UserDaoOracleImpl;
import com.wkk.service.UserService;

/**
 * @Time: 20-2-6上午11:03
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class UserServiceImplTest {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
//        userService.setUserDao(new UserDaoMysqlImpl());
//        userService.setUserDao(new UserDaoOracleImpl());
        userService.setUserDao(new UserDaoImpl());
        userService.getUser();

    }

}

package com.wkk.dao.impl;

import com.wkk.dao.UserDao;

/**
 * @Time: 20-2-6上午11:07
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class UserDaoMysqlImpl implements UserDao {
    public void getUser() {
        System.out.println("使用MySQL获取用户数据");
    }
}

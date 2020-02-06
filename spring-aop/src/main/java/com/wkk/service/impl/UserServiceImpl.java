package com.wkk.service.impl;

import com.wkk.service.UserService;

/**
 * @Time: 20-2-6下午9:51
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class UserServiceImpl implements UserService {
    public void add() {
        System.out.println("增加了一个用户");
    }

    public void delete() {
        System.out.println("删除了一个用户");
    }

    public void update() {
        System.out.println("更新了一个用户");
    }

    public void query() {
        System.out.println("查询了一个用户");
    }
}

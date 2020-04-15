package com.wkk.anno;

import org.springframework.stereotype.Component;

/**
 * @Time: 20-4-15上午9:26
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
@Component
public class UserDaoImpl1 implements UserDao {
    public void say() {
        System.out.println("这是UserDao的第一种实现方式");
    }
}

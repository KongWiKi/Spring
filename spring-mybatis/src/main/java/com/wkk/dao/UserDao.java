package com.wkk.dao;

import com.wkk.pojo.User;

import java.util.List;

/**
 * @Time: 20-2-7上午9:18
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public interface UserDao {
    List<User> selectUser();
}

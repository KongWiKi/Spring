package com.wkk.dao;

import com.wkk.pojo.Student;

import java.util.List;

/**
 * @Time: 20-2-7下午3:44
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public interface UsersDao {
    List<Student> queryUser();

    // 添加一个用户
    int addUser(Student user);

    // 删除一个用户
    int deleteUser(int id);
}

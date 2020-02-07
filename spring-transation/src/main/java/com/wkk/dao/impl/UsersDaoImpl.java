package com.wkk.dao.impl;

import com.wkk.dao.UsersDao;
import com.wkk.pojo.Student;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

/**
 * @Time: 20-2-7下午4:06
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class UsersDaoImpl implements UsersDao {
    private SqlSessionTemplate sessionTemplate;

    public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
        this.sessionTemplate = sessionTemplate;
    }

    public List<Student> queryUser() {
        Student user = new Student(9, "孔维坤", "124312");
        UsersDao mapper = sessionTemplate.getMapper(UsersDao.class);
        mapper.addUser(user);
        mapper.deleteUser(5);
        return mapper.queryUser();
    }

    public int addUser(Student user) {
        return sessionTemplate.getMapper(UsersDao.class).addUser(user);
    }

    public int deleteUser(int id) {
        return sessionTemplate.getMapper(UsersDao.class).deleteUser(id);
    }
}

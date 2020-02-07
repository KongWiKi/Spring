package com.wkk.dao.impl;

import com.wkk.dao.UserDao;
import com.wkk.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Time: 20-2-7下午2:27
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class UserDaoImpl implements UserDao {
    // 原先所有使用SqlSessionFactory 现在为SqlSessionFactoryTemplate
    private SqlSessionTemplate sessionTemplate;

    // 注入
    public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
        this.sessionTemplate = sessionTemplate;
    }

    public List<User> selectUser() {
        UserDao mapper = sessionTemplate.getMapper(UserDao.class);
        return mapper.selectUser();

    }
}

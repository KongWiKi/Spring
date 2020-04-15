package com.wkk.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @Time: 20-4-15上午9:26
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
@Component
public class UserService {
    @Autowired
    @Qualifier("userDaoImpl2")
    private UserDao userDao;

    public void say(){
        userDao.say();
    }
}

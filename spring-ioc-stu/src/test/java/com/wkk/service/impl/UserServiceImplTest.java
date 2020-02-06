package com.wkk.service.impl;

import com.wkk.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Time: 20-2-6上午11:03
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class UserServiceImplTest {
    public static void main(String[] args) {
//        UserService userService = new UserServiceImpl();
////        userService.setUserDao(new UserDaoMysqlImpl());
////        userService.setUserDao(new UserDaoOracleImpl());
//        userService.setUserDao(new UserDaoImpl());
//        userService.getUser();

        //通过spring托管 获取对应的bean
        ApplicationContext context = new ClassPathXmlApplicationContext("mybeans.xml");
        UserService userServiceImpl = (UserService) context.getBean("userServiceImpl");
        userServiceImpl.getUser();




    }

}

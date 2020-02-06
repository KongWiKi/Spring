package com.wkk.service.impl;


import com.wkk.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Time: 20-2-6下午10:22
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class UserServiceImplTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        UserService userService = (UserService) context.getBean("userService", UserService.class);
        userService.query();

    }
}

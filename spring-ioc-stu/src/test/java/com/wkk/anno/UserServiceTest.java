package com.wkk.anno;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Time: 20-4-15上午9:30
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JavaConfig.class)
public class UserServiceTest {

    @Autowired
    UserService userService;
    @Test
    public void say() {
        Assert.assertNotNull(userService);
    }
}

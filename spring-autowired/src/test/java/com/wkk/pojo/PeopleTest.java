package com.wkk.pojo;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Time: 20-2-6下午7:17
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class PeopleTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        People people = context.getBean("people", People.class);
        people.getCat().shout();
        people.getDog().shout();


    }

}

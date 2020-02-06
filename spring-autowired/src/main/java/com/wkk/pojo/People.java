package com.wkk.pojo;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Time: 20-2-6下午7:10
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class People {
    @Autowired
    private Cat cat;
    @Autowired
    private Dog dog;
    private String name;

    public String getName() {
        return name;
    }


    public Cat getCat() {
        return cat;
    }


    public Dog getDog() {
        return dog;
    }


    @Override
    public String toString() {
        return "People{" +
                "cat=" + cat +
                ", dog=" + dog +
                ", name='" + name + '\'' +
                '}';
    }
}

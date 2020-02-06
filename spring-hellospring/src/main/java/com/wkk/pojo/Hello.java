package com.wkk.pojo;

/**
 * @Time: 20-2-6下午2:04
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Hello {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show(){
        System.out.println("Hello " + name);
    }

    @Override
    public String toString() {
        return "Hello{" +
                "name='" + name + '\'' +
                '}';
    }
}

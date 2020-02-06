package com.wkk.pojo;

/**
 * @Time: 20-2-6下午3:14
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class User {
    private String name;

//    public User() {
//        System.out.println("User的无参构造");
//    }
    public User(String name){
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show(){
        System.out.println("name: " + name);
    }
}

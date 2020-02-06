package com.wkk;

/**
 * @Time: 20-2-6下午8:58
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Client {
    public static void main(String[] args) {
        UserProxy proxy = new UserProxy();
        proxy.setUserService(new UserServiceImpl());
        proxy.add();

    }
}

package com.wkk;

import org.w3c.dom.UserDataHandler;

/**
 * @Time: 20-2-6下午9:01
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class UserProxy implements UserService {
    private UserServiceImpl userService;

    //注入
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }



    public void log(String msg){ ;
        System.out.println("[Debug]使用" + msg + "方法");
    }

    public void add() {
        log("增");
        userService.add();
    }

    public void delete() {
        log("删");
        userService.delete();
    }

    public void upate() {
        log("改");
        userService.upate();
    }

    public void query() {
        log("查");
        userService.query();
    }
}

package com.wkk.pointcut;

/**
 * @Time: 20-2-7上午8:32
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class DiyPointcut {
    public void before(){
        System.out.println("--------方法执行前------------");
    }

    public void after(){
        System.out.println("--------方法执行后-------------");
    }
}

package com.wkk.log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @Time: 20-2-6下午9:53
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Log implements MethodBeforeAdvice {
    /**
     *
     * @param method 需要执行目标对象的方法
     * @param objects 被调用的方法的参数
     * @param o 目标对象
     * @throws Throwable
     */
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println(o.getClass().getName() + "的" + method.getName() + "方法被执行了");
    }

}

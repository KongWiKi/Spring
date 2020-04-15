package com.wkk.auto;

import org.springframework.stereotype.Component;

/**
 * @Time: 20-4-14下午1:04
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
//表明该类会作为组件类
//并让spring为其创建bean
//但是默认是不开启的 需要显示的配置Spring(@ComponentScan)
//让其去寻找带有@component的注解类
@Component
public class SgtPeppers implements CompactDisc {
    private final String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private final String artist = "The Beatles";

    public void play() {
        System.out.println("Playing " + title + " Artist " + artist);
    }
}

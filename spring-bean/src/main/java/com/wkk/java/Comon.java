package com.wkk.java;

/**
 * @Time: 20-4-14下午7:10
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Comon implements CompactDisc {
    private final String title = "加油";
    private final String artist = "100天";
    public void play() {
        System.out.println("CD名： " + title + " 专辑 " + artist);
    }
}

package com.wkk.java;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Time: 20-4-14下午7:09
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class CDPlayer implements MediaPlayer{
    private CompactDisc cd;

    @Autowired
    public void setCd(CompactDisc cd){
        this.cd = cd;
    }


    public void play() {
        cd.play();
    }
}

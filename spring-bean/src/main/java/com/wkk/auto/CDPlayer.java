package com.wkk.auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Time: 20-4-14下午12:56
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
@Component
public class CDPlayer implements MediaPlayer {
    private CompactDisc cd;

    @Autowired
    public CDPlayer(CompactDisc cd){
        this.cd = cd;
    }

    public void play() {
        System.out.println("cd一号机播放");
        cd.play();
    }
}

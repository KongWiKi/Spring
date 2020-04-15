package com.wkk.java;

import com.wkk.java.CompactDisc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Time: 20-4-14下午7:06
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
@Configuration
public class CDPlayerConfig {
    @Bean
    public CompactDisc compactDisc(){
        return new Comon();
    }

    @Bean
    public CDPlayer cdPlayer(CompactDisc compactDisc){
        CDPlayer cdPlayer = new CDPlayer();
        cdPlayer.setCd(compactDisc);
        return cdPlayer;
    }
}

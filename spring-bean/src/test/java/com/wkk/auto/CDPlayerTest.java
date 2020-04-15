package com.wkk.auto;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @Time: 20-4-14下午1:32
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {
    @Rule
    public final SystemOutRule log = new SystemOutRule();

    @Autowired
    private CompactDisc cd;

    @Autowired
    private MediaPlayer player;

    @Test
    public void cdShouldNotBeNull(){
        player.play();
        assertNotNull(cd);
    }

    @Test
    public void play(){
        player.play();

//        assertEquals("Playing Sgt. Pepper's Lonely Hearts Club Band Artist The Beatles",
//                log.getLog());
    }

}

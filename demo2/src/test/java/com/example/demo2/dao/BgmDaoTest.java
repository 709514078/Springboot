package com.example.demo2.dao;

import com.example.demo2.entity.Bgm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BgmDaoTest {

    @Autowired
    private BgmDao bgmDao;

    @Test
    public void queryBgm() {
        List<Bgm> bgmList = bgmDao.queryBgm();
        System.err.println("--------------"+bgmList);
        assertEquals(12,bgmList.size());
    }

    @Test
    public void queryBgmById() {
        Bgm bgm = bgmDao.queryBgmById("180530DXKK4YYGTC");
        System.err.println("------------"+bgm.getId());
        assertEquals("180530DXKK4YYGTC",bgm.getId());
    }

    @Test
    public void insertBgm() {
    }

    @Test
    public void updateBgm() {
    }

    @Test
    public void deleteBgm() {
    }
}
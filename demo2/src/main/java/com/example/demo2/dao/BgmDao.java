package com.example.demo2.dao;

import com.example.demo2.entity.Bgm;

import java.util.List;

public interface BgmDao {

    List<Bgm> queryBgm();

    Bgm queryBgmById(String id);

    int saveBgmManage (Bgm bgm);

    int updateBgm(Bgm bgm);

    int deleteBgmById(String id);

}

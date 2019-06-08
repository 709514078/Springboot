package com.example.demo2.service;

import com.example.demo2.entity.Bgm;

import java.util.List;

public interface BgmService {

    List<Bgm> getBgmList();

    Bgm getBgmById(String id);

    boolean saveBgmManage(Bgm bgm);

    boolean deleteBgmById(String id);

    boolean updateBgm(Bgm bgm);
}

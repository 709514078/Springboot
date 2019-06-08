package com.example.demo2.service.impl;

import com.example.demo2.dao.BgmDao;
import com.example.demo2.entity.Bgm;
import com.example.demo2.service.BgmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.util.StringUtils.isEmpty;

@Service
public class BgmServiceImpl implements BgmService {

    @Autowired
    private BgmDao bgmDao;

    @Override
    public List<Bgm> getBgmList() {
        return bgmDao.queryBgm();
    }

    @Override
    public Bgm getBgmById(String id) {
        return bgmDao.queryBgmById(id);
    }

    @Transactional
    @Override
    public boolean saveBgmManage(Bgm bgm) {
        if (bgm.getName() != null && !"".equals(bgm.getName())) {
            try {
                int effectedNum = bgmDao.saveBgmManage(bgm);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入失败！！！");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入失败！！！" + e.getMessage());
            }
        } else {
            throw new RuntimeException("插入信息不能为空！！！");
        }
    }

    @Override
    public boolean deleteBgmById(String id) {
        if (id != null || id != ""){
            try{
                int effectedNum = bgmDao.deleteBgmById(id);
                if (effectedNum > 0){
                    return true;
                } else {
                    throw new RuntimeException("删除信息失败！！！");
                }
            }catch (Exception e){
                throw new RuntimeException("删除信息失败！！！" + e.toString());
            }
        } else {
            throw new RuntimeException("id不能为空！！！");
        }
    }

    @Override
    public boolean updateBgm(Bgm bgm) {
        if (!isEmpty(bgm)){
            try{
                int effectedNum = bgmDao.updateBgm(bgm);
                if (effectedNum > 0 ) {
                    return true;
                } else {
                    throw new RuntimeException("修改异常！！！");
                }
            }catch (Exception e){
                throw new RuntimeException("修改异常！！！");
            }

        } else {
            throw new RuntimeException("数据不能为空！！！");
        }
    }
}

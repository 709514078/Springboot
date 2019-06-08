package com.example.demo2.web;

import com.example.demo2.entity.Bgm;
import com.example.demo2.service.BgmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bgm")
@CrossOrigin
public class BgmController {

    @Autowired
    private BgmService bgmService;

//    @RequestMapping(value="/listBgm", method = RequestMethod.GET,consumes = Bgm.CONTENT_TYPE_FROMED)
//    public String  listBgm(@RequestParam("callback") String callback){
//        Map<String,Object> modelList = new HashMap<String,Object>();
//        List<Bgm> listBgm = bgmService.getBgmList();
//        modelList.put("listBgm",listBgm);
//        JSONObject json =new JSONObject(modelList);
//        return callback+"("+json+")";
//    }

    @RequestMapping(value="/listBgm", method = RequestMethod.GET)
    public Map<String, Object>  listBgm(){
        Map<String,Object> modelList = new HashMap<String,Object>();
        List<Bgm> listBgm = bgmService.getBgmList();
        modelList.put("listBgm",listBgm);
        return  modelList ;
    }

    @RequestMapping(value = "/bgmById", method = RequestMethod.GET)
    public Map<String,Object> bgmById(String id){
        Map<String,Object> bgmMap = new HashMap();
        Bgm bgm = bgmService.getBgmById(id);
        bgmMap.put("bgm",bgm);
        return bgmMap;
    }

    //,consumes = Bgm.CONTENT_TYPE_FROMED
    @RequestMapping(value = "/saveBgmManage", method = RequestMethod.GET)
    public Map<String,Object> saveBgmManage(Bgm bgm){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        modelMap.put("success",bgmService.saveBgmManage(bgm));
        return modelMap;
    }

    @RequestMapping(value = "/deleteBgmManage",method = RequestMethod.GET)
    public Map<String,Object> deleteBgmManage(String[] id){
        Map<String,Object> map = new HashMap<>();
        for (String i : id) {
            map.put("success",bgmService.deleteBgmById(i));
        }
        return map;
    }

    @RequestMapping(value = "/updateBgm",method = RequestMethod.GET)
    public Map<String,Object> updateBgm(Bgm bgm){
        System.out.println("----------"+bgm.toString());
        Map<String,Object> map = new HashMap<>();
        map.put("success",bgmService.updateBgm(bgm));

        return map;
    }

}

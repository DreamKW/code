package com.etc.mybatis.ui;

import com.etc.mybatis.entity.Tuser;
import com.etc.mybatis.service.TuserService;

import java.util.List;

public class TuserTest {
    public static void main(String[] args) {
        TuserService tuserService = new TuserService();
//        tuserService.addTuser("b",18);
//        System.out.println(tuserService.deleTuser("bb"));
//        System.out.println(tuserService.updateTuser("b",222));
        System.out.println(tuserService.getOne(1));
//        List<Tuser> list = tuserService.getAll();
//        if (list != null){
//
//        }
    }

}

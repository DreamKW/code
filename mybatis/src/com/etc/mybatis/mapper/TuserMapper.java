package com.etc.mybatis.mapper;

import com.etc.mybatis.entity.Tuser;

import java.util.List;

public interface TuserMapper {
//    添加用户信息
     void addTuser(String uname,int age);
//   删除用户信息
    int deleTuser(String uname);
//    修改用户信息
    int updateTuser(String uname, int age);

    Tuser getOne(int tuserid);
//
    List<Tuser> getAll();
}

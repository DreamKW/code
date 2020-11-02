package com.etc.mybatis.service;

import com.etc.mybatis.entity.Tuser;
import com.etc.mybatis.mapper.BaseDao;
import com.etc.mybatis.mapper.TuserMapper;

import java.util.List;

public class TuserService extends BaseDao {
//    TuserSrvice ->  TuserMapper -> TuserMapper.xml'
//所有用户信息
    public List<Tuser> getAll(){
        open();
        TuserMapper tuserMapper = session.getMapper(TuserMapper.class);
        List<Tuser> list = tuserMapper.getAll();
        closeResource();
        return list;
    }

//    查询某个用户信息
    public Tuser getOne(int tuserid){
        open();
        TuserMapper tuserMapper = session.getMapper(TuserMapper.class);
        Tuser  tuser = tuserMapper.getOne(tuserid);
        closeResource();
        return tuser;
    }

//    修改
    public int updateTuser(String uname,int age){
        open();
        TuserMapper tuserMapper = session.getMapper(TuserMapper.class);
        int no = tuserMapper.updateTuser(uname,age);
        closeResource();
        return no;
    }


//    删除
    public int deleTuser(String uname){
        open();
        TuserMapper tuserMapper = session.getMapper(TuserMapper.class);
        int no = tuserMapper.deleTuser(uname);
        closeResource();
        return no;
    }

    //添加用户信息
    public void addTuser(String uname , int age){
        //打开数据库
        open();
        //先从session中获取到接口
        TuserMapper tuserMapper = session.getMapper(TuserMapper.class);
        //调用需要执行的功能方法
        tuserMapper.addTuser(uname , age) ;
        //关闭数据库
        closeResource();
    }
}

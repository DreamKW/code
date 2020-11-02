package com.etc.flower.service;

import com.etc.flower.entity.*;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public interface UserService {
//    登录功能
    public Tuser login(String username, String pwd,String role) throws SQLException;
//    显示鲜花信息
    public List<Flower> getAll(int page,int count)throws SQLException;
//    显示某个鲜花详情
    Flower getOne(int id) throws  SQLException;
//添加购物车
    int addCar (Tuser tuser,int id) throws SQLException;
//    显示购物车中的信息
    List<ShopCar> getCar(Tuser tuser) throws SQLException;
    List<Address> getAddress(Tuser tuser) throws  SQLException;

    boolean addAddress(Tuser tuser, String address) throws SQLException;

    Address getAddressone(Tuser tuser) throws SQLException;

    boolean updateDeafultAddress(Tuser tuser,String defaultaddress) throws SQLException;
    void pay(Tuser tuser, double sum, Map<String,Integer> countMap , Map<String,Double>sumMap , String [] sids,String addressid) throws Exception;

    int removeCar(Tuser tuser, int flowerid) throws Exception;

    void upload(Flower flower) throws SQLException;
//    查询订单信息 （多条件）
    List<Forder> getOrder(Tuser tuser, Date start,Date end)throws SQLException;

    List<SelectOrder> getSelectOrder(Tuser tuser, Date s, Date e1) throws SQLException;
//  计算一共有多少页
    int getPage(int i) throws SQLException;

    /**
     * 判断是否已有此用户
     * @param uname
     * @return
     * @throws SQLException
     */
    boolean judge(String uname) throws SQLException;
}

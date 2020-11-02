package com.etc.flower.serviceImpl;

import com.etc.flower.dao.UserDao;
import com.etc.flower.daoImpl.UserDaoImpl;
import com.etc.flower.entity.*;
import com.etc.flower.service.UserService;
import com.etc.flower.util.Log;

import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    UserDao dao = new UserDaoImpl();
//登录
    @Override
    public Tuser login(String username, String pwd,String role) throws SQLException {

        Tuser tuser = null;
       try {
           tuser = dao.login(username,pwd,role);


       }catch (Exception e){
//           日志
           e.printStackTrace();
           Log.mylog.debug(e.getMessage()+"登录！！！");

       }finally {
//           关闭数据库
          ((UserDaoImpl) dao).closeResoure();
       }

        return tuser;
    }

//    显示鲜花信息
    @Override
    public List<Flower> getAll(int page,int count) throws SQLException {
        List<Flower> flowers = new ArrayList();
        try {
            flowers = dao.getAll(page,count);
        }catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug("显示鲜花信息"+e.getMessage());
        }finally {
            ((UserDaoImpl)dao).closeResoure();
        }
        return flowers;
    }

    @Override
    public Flower getOne(int id) throws SQLException {
        Flower flower = null;
        try {
            flower = dao.getOne(id);
        }catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug("显示一个鲜花信息"+e.getMessage());
        }finally {
            ((UserDaoImpl)dao).closeResoure();
        }
        return flower;
    }

    @Override
    public int addCar(Tuser tuser, int id) throws SQLException {
        int no = 0;
        try{
//        判断购物车是否有鲜花
           if ( dao.judgeCar(tuser,id)){
//        如果有此鲜花，则不需要再添加到购物车
               no = 6;

           }else {
//        如果没有此鲜花，则需要添加到购物车
              no =  dao.addCar(tuser,id);
           }
        }catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug("添加购物车"+e.getMessage());
        }finally {
            ((UserDaoImpl)dao).closeResoure();
        }
        return  no;
    }

    /**
     * 获取购物车中的鲜花信息
     * @param tuser
     * @return
     * @throws SQLException
     */

    @Override
    public List<ShopCar> getCar(Tuser tuser) throws SQLException {
        List<ShopCar> shopCars = null;
        try{
            shopCars = dao.getCar(tuser);
        }catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug(e.getMessage()+"购物车鲜花信息");
        }finally {
            ((UserDaoImpl)dao).closeResoure();
        }
        return shopCars;
    }

    /**
     * 显示默认地址
     * @param tuser
     * @return
     * @throws SQLException
     */
    @Override
    public List<Address> getAddress(Tuser tuser) throws SQLException {
        List<Address> addresslist = null;
        try{
            addresslist = dao.getAddress(tuser);
        }catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        }finally {
            ((UserDaoImpl)dao).closeResoure();
        }
        return addresslist;
    }

    @Override
    public boolean addAddress(Tuser tuser, String address) throws SQLException {
        boolean flag = false;
        try{
            flag = dao.addAddress(tuser,address);
        }catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        }finally {
            ((UserDaoImpl)dao).closeResoure();
        }
        return flag;
    }

    @Override
    public Address getAddressone(Tuser tuser) throws SQLException {
        Address address = null;
        try{
            address = dao.getAddressone(tuser);
        }catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        }finally {
            ((UserDaoImpl)dao).closeResoure();
        }
        return address;
    }

    @Override
    public boolean updateDeafultAddress(Tuser tuser,String defaultaddress) throws SQLException {

        boolean flag = false;
        try{
            flag = dao.updateDeafultAddress(tuser,defaultaddress);
        }catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        }finally {
            ((UserDaoImpl)dao).closeResoure();
        }
        return flag;
    }

    @Override
    public void pay(Tuser tuser, double sum, Map<String,Integer> countMap ,Map<String,Double>sumMap ,String [] sids,String addressid) throws Exception{
        //启动事务
        ((UserDaoImpl)dao).openTransaction();
        try {
            //修改帐户余额: Tuser,交易总价sum
            dao.updateCount(tuser,sum);
            //修改各自鲜花的数量:根据鲜花的ID得到鲜花的数量: countMap
            for (String fid :
                    sids) {
                int flowerid = Integer.parseInt(fid);
                int count = countMap.get(fid);
                dao.updateFcount(flowerid,count);
            }
            // 添加订单信息: Tuser ,sum
            dao.addOrder(tuser,sum,addressid);
//            获取到订单的ID号
            int oid = dao.getOid();
            //添加订单详情：鲜花的数量: countMap,每一种鲜花支付的总额sumMap
            for (String fid:
                 sids  ) {
                int flowerid = Integer.parseInt(fid);
                int count = countMap.get(fid);
                double fsum = sumMap.get(fid);
                dao.addDetail(oid,flowerid,count,fsum);
                //清理购物车：鲜花的ID数组：sids
                dao.removeCar(tuser,flowerid);
            }

            //事务提交
            ((UserDaoImpl)dao).commitTransaction();

        }catch (Exception e){
            //回滚事务
            ((UserDaoImpl)dao).rollbackTransaction();
            e.printStackTrace();
            Log.mylog.debug(e.getMessage()+"结算");
        }finally {
            ((UserDaoImpl)dao).closeResoure();
        }
    }

    @Override
    public int removeCar(Tuser tuser, int flowerid) throws Exception {
//        打开事务
        ((UserDaoImpl)dao).openTransaction();
        int s = 0 ;
            try {
                s = dao.removeCar(tuser,flowerid);
//                提交事务
                ((UserDaoImpl)dao).commitTransaction();
            } catch (Exception e) {
//                回滚事务
                ((UserDaoImpl)dao).rollbackTransaction();
                Log.mylog.debug(e.getMessage());
                e.printStackTrace();
            }finally {
//                关闭事务
                ((UserDaoImpl)dao).closeResoure();
            }
        return s;
    }

    /**
     * 上传鲜花信息
     * @param flower
     */
    @Override
    public void upload(Flower flower) throws SQLException {
        try {
            dao.upload(flower);
        }catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        }finally {
            ((UserDaoImpl)dao).closeResoure();
        }
    }

    /**
     * 查询订单信息
     * @param tuser
     * @param start
     * @param end
     * @return
     * @throws SQLException
     */
    @Override
    public List<Forder> getOrder(Tuser tuser, Date start, Date end) throws SQLException {
        List<Forder> forderList = null;
        try{
           forderList= dao.getOrder(tuser,start,end);
        }catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        }finally {
            ((UserDaoImpl)dao).closeResoure();
        }
        return forderList;
    }

    @Override
    public List<SelectOrder> getSelectOrder(Tuser tuser, Date s, Date e1) throws SQLException {
        List<SelectOrder> selectOrderList = null;
        try {
            selectOrderList = dao.getSelectOrder(tuser,s,e1);
        }catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        }finally {
            ((UserDaoImpl)dao).closeResoure();
        }
        return selectOrderList;
    }

    @Override
    public int getPage(int i) throws SQLException {
        int all = 0;
        try{
           all = dao.getPage(i);
        }catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug(e.getMessage());
        }finally {
            ((UserDaoImpl)dao).closeResoure();
        }
        return all;
    }

    /**
     * 判断是否已有此用户
     * @param uname
     * @return
     * @throws SQLException
     */
    @Override
    public boolean judge(String uname) throws SQLException {
        boolean flag = false;
        try{
            flag =  dao.judge(uname);
        }catch (Exception e){
            e.printStackTrace();
            Log.mylog.debug(e.getMessage()+"判断是否已有此用户");
        }finally {
            ((UserDaoImpl)dao).closeResoure();
        }
        return flag;
    }
}

















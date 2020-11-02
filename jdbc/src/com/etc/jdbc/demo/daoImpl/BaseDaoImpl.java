package com.etc.jdbc.demo.daoImpl;

import com.etc.jdbc.demo.dao.BaseDao;
import com.etc.jdbc.demo.util.DbInfo;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.*;

public class BaseDaoImpl implements BaseDao {
    //定义所有数据库对象
    public Connection con;
    public PreparedStatement ps;
    public ResultSet rs;
    public Statement st;
    //打开数据库
    public static void main(String[] args) throws Exception {
        new BaseDaoImpl().openDb();
    }
    public void openDb() throws Exception {
        //创建dbinfo实例  因为设置为单例，所以只能通过getinfostace()来获取实例
        DbInfo dbInfo = DbInfo.getInstance();
        //获取Configinfo实例
        DbInfo.ConfigInfo configInfo = dbInfo.getProperties();
        //添加驱动
        Class.forName(configInfo.getDbdriver());
        //数据库的连接
        con = DriverManager.getConnection(configInfo.getDbURL()
                ,configInfo.getUname(),configInfo.getPwd());
//        System.out.println("yes");
//        //添加驱动
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        //数据库的连接
//        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8","root","2721kkww=-");
//
    }
    //关闭资源
    public void closeResoure() throws SQLException {
        if (con != null){
            con.close();
        }
        if (ps != null){
            ps.close();
        }
        if (rs != null){
            rs.close();
        }if(st != null){
            st.close();
        }
    }

    @Override
    public void openTransaction() throws Exception {
        //打开事务就是将之前的数据库自动提交功能修改为false
        openDb();
        if (con != null){
            con.setAutoCommit(false);
        }
    }

    @Override
    public void commitTransaction() throws SQLException {
        //提交事务
        if (con != null){
            con.commit();
        }
    }

    @Override
    public void rollbackTransaction() throws SQLException {
        //回滚
        if (con != null){
            con.rollback();
        }

    }
}

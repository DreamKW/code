package book.daoImpl;

import book.dao.BaseDao;
import book.util.DbInfo;
import book.util.DbInfoOracle;

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

    public void openDb() throws ClassNotFoundException, SQLException, IOException, URISyntaxException {
//        创建dbinfo实例 oracle
        DbInfoOracle dbInfo = DbInfoOracle.getInstance();
//        mysql 数据库
//        DbInfo dbInfo = DbInfo.getInstance();

//        获取configinfo 实例
        DbInfoOracle.ConfigInfo configInfo = dbInfo.getProperties();
//        添加驱动
        Class.forName(configInfo.getDbdriver());
//        数据库的连接
        con = DriverManager.getConnection(configInfo.getDbURL(),configInfo.getUname(),configInfo.getPwd());
        System.out.println("yes");
//        //添加驱动
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        //数据库的连接
//         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book?useSSL=false&serverTimezone=UTC&characterEncoding=utf-8","root","2721kkww=-");
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
        }
    }

    @Override
    public void openTransaction() throws SQLException, URISyntaxException, IOException, ClassNotFoundException {
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

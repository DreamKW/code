package com.etc.mybatis.mapper;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class BaseDao {
    static SqlSessionFactory sqlSessionFactory;
    public SqlSession session ;
static {
    InputStream inputStream = null;
    String resource = "mybatis.xml";
    try {
         inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
//打开数据库
    public void open(){
        if (sqlSessionFactory != null){
        session =  sqlSessionFactory.openSession(true);
            }
        }

//  关闭数据库
    public void closeResource(){
        if (session != null){
            session.close();
        }
    }

}

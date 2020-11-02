package com.etc.jdbc.demo.dao;

import com.etc.jdbc.demo.entity.Student;
import com.etc.jdbc.demo.entity.Student1;
import com.etc.jdbc.demo.entity.Tclass;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
    //添加班级信息
    public int addClass(Tclass tclass) throws Exception;
    public int addStudent(Student student,int cid) throws Exception;

    //登录
    public Student1 login (String username, String pwd) throws ClassNotFoundException, SQLException, IOException, URISyntaxException, Exception;
    //查询所有学生信息
    public List<Student1> getAll() throws Exception;

    boolean update(String name, int age) throws Exception;

    boolean delete(String name) throws Exception;

    boolean add(String name, int age, String pwd) throws Exception;
//获取班级学生信息
    List<Tclass> getClassStudent() throws Exception;

    int deleteStu(String cname) throws Exception;

    int deleteClass(String cname) throws Exception;
}

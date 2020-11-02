package com.etc.jdbc.demo.service;

import com.etc.jdbc.demo.entity.Student1;
import com.etc.jdbc.demo.entity.Tclass;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.List;

public interface StudentService {
//    登录功能


    Student1 login (String username, String pwd) throws SQLException;
    List<Student1> getAll() throws SQLException, ClassNotFoundException;

    boolean  update(String name, int age) throws SQLException, ClassNotFoundException, IOException, URISyntaxException;

    boolean delete(String name) throws SQLException;

    boolean add(String name, int age, String pwd) throws SQLException;

    List<Tclass> getClassStudent() throws SQLException, ClassNotFoundException;

    int deleteclass(String cname) throws SQLException;
}

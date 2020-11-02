package com.etc.flower.controller;

import com.etc.flower.service.UserService;
import com.etc.flower.serviceImpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PipedWriter;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/registerServet")
public class registerServet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("uname");
        System.out.println(uname);
        PrintWriter out = response.getWriter();
        UserService userService = new UserServiceImpl();
        if (uname != null && !"".equals(uname)){
            try {
                boolean flag =  userService.judge(uname);
                if (flag){
                    out.println("有此用户名了，请换个名吧！！");
                }else {
                    out.println("可以使用此用户名");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            out.println("用户名不能为空！！！");
        }

    }
}

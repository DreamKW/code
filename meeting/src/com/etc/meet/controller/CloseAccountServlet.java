package com.etc.meet.controller;

import com.etc.meet.service.UserService;
import com.etc.meet.serviceImpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/CloseAccountServlet")
public class CloseAccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userid = Integer.parseInt(request.getParameter("uid"));
        UserService userService = new UserServiceImpl();
        int s = 0;
        try {
            s = userService.closeAccount(userid);
            if (s > 0 ){
                request.setAttribute("result","关闭账户成功");
                request.getRequestDispatcher("searchemployees.jsp").forward(request,response);
            }else {
                request.setAttribute("result","关闭账户失败");
                request.getRequestDispatcher("searchemployees.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

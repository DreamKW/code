package com.etc.flower.controller;

import com.etc.flower.entity.Tuser;
import com.etc.flower.service.UserService;
import com.etc.flower.serviceImpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/updatedefaultAddressServlet")
public class updatedefaultAddressServlet extends HttpServlet {

    UserService us = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
//        session.setAttribute("tz","updatedefaultAddressServlet");
        String defaultaddress = request.getParameter("addressupdate");
        Tuser tuser = (Tuser)session.getAttribute("tuser");

        try {
            us.updateDeafultAddress(tuser,defaultaddress);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("SubmitCarServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

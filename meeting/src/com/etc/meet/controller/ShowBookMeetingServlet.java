package com.etc.meet.controller;

import com.etc.meet.entity.Department;
import com.etc.meet.entity.Meetroom;
import com.etc.meet.service.UserService;
import com.etc.meet.serviceImpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/ShowBookMeetingServlet")
public class ShowBookMeetingServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        try {
            List<Department> departmentList = userService.selectDeparment();
            for (Department department  :
                departmentList ) {
                System.out.println(department);
            }
            List<Meetroom> meetroomList  = userService.selectMeetRoom();

            request.setAttribute("departmentList",departmentList);
            request.setAttribute("meetroomList",meetroomList);
            request.getRequestDispatcher("bookmeeting.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

package com.etc.flower.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/TestServlet")
public class TsetServlet extends HttpServlet {
    public TsetServlet() {
        System.out.println("TestServlet");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String [] hobbies = request.getParameterValues("hobby");
        if (hobbies != null){
            for (String hobby :
                    hobbies) {
                System.out.println(hobby);
            }
        }
        request.setAttribute("result","能看见我不？");
        request.getRequestDispatcher("login.jsp").forward(request,response);
//        response.sendRedirect("login.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("注解doGet");
        System.out.println(request.getSession().getAttribute("tt").toString());
    }
}

package com.etc.meet.filter;


import com.etc.meet.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/ShowBookMeetingServlet")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter");
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response =(HttpServletResponse)servletResponse;
        HttpSession session = request.getSession();

       User user = (User) session.getAttribute("user");
        if (user == null){
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("ShowBookMeetingServlet").forward(request,response);
        }
    }

    @Override
    public void destroy() {


    }
}

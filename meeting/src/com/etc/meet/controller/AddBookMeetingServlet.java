package com.etc.meet.controller;

import com.etc.meet.entity.Meeting;
import com.etc.meet.entity.User;
import com.etc.meet.service.UserService;
import com.etc.meet.serviceImpl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/AddBookMeetingServlet")
public class AddBookMeetingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        User user = (User) request.getSession().getAttribute("user");
        int uid = user.getUserid();
        String[] usersid  =  request.getParameterValues("selSelectedEmployees");
       String description = request.getParameter("description");
       int roomid = Integer.parseInt(request.getParameter("roomid"));
       String begindate = request.getParameter("startdate");
       String begintime = request.getParameter("starttime");
       String begin = begindate + " " + begintime + ":"+ "35";
       String enddate = request.getParameter("enddate");
       String endtime = request.getParameter("endtime");
       String end = enddate + " " + endtime + ":"+ "35";
//       参加会议人数
       int numofattendents = Integer.parseInt(request.getParameter("numofattendents"));
//       会议名称
       String meetingname = request.getParameter("meetingname");

        try {
            //            判断改时间此会议室是否已被预定
            Meeting meeting = userService.meetTimed(roomid,begin,end);

            if (meeting == null){
                int s = userService.addMeeting(uid,meetingname,numofattendents,begin,end,roomid,description,usersid);
                if (s > 0){
                    request.setAttribute("result","预定成功");
                    request.getRequestDispatcher("ShowBookMeetingServlet").forward(request,response);
                }else {
                    request.setAttribute("result","预定失败");
                    request.getRequestDispatcher("ShowBookMeetingServlet").forward(request,response);
                }
            }else{
                request.setAttribute("result","预定失败："+meeting.getBegindate()+"--"+meeting.getEnddate()+"时间段本会议室已被预定");
                request.getRequestDispatcher("ShowBookMeetingServlet").forward(request,response);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

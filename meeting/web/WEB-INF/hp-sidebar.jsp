<%--
  Created by IntelliJ IDEA.
  User: kkww
  Date: 2020/10/10
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>page-sidebar</title>
</head>
<body>
<div class="page-sidebar">
    <div class="sidebar-menugroup">
        <div class="sidebar-grouptitle">个人中心</div>
        <ul class="sidebar-menu">
            <li class="sidebar-menuitem"><a href="show.action">最新通知</a></li>
            <li class="sidebar-menuitem active"><a href="showMyBooking.action">我的预定</a></li>
            <li class="sidebar-menuitem"><a href="showMyMeeting.action">我的会议</a></li>
        </ul>
    </div>
    <c:if test="${user.role == '管理员'}" >
        <div class="sidebar-menugroup">
            <div class="sidebar-grouptitle">人员管理</div>
            <ul class="sidebar-menu">
                <li class="sidebar-menuitem"><a href="showDep.action">部门管理</a></li>
                <li class="sidebar-menuitem"><a href="showRegister.action">员工注册</a></li>
                <li class="sidebar-menuitem"><a href="showApproveAccount.action">注册审批</a></li>
                <li class="sidebar-menuitem"><a href="go.action?go=searchemployees.jsp">搜索员工</a></li>
            </ul>
        </div>
    </c:if>




    <div class="sidebar-menugroup">
        <div class="sidebar-grouptitle">会议预定</div>
        <ul class="sidebar-menu">
            <c:if test="${user.role == '管理员'}" >
                <li class="sidebar-menuitem"><a href="addmeetingroom.jsp">添加会议室</a></li>
            </c:if>
            <li class="sidebar-menuitem"><a href="ShowRoomServlet">查看会议室</a></li>
            <li class="sidebar-menuitem"><a href="ShowBookMeetingServlet">预定会议</a></li>
            <li class="sidebar-menuitem"><a href="searchmeetings.jsp">搜索会议</a></li>
        </ul>
    </div>
</div>
</body>
</html>

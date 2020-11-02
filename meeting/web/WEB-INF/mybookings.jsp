<%--
  Created by IntelliJ IDEA.
  User: kkww
  Date: 2020/10/14
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset = "utf-8"/>
    <title>CoolMeeting会议管理系统</title>
    <link rel="stylesheet" href="styles/common.css"/>
    <style type="text/css">

    </style>
</head>
<body>
<jsp:include page="head.jsp"/>
<div class="page-body">
    <jsp:include page="hp-sidebar.jsp"/>
    <div class="page-content">
        <div class="content-nav">
            个人中心 > 我的预定
        </div>
        <table class="listtable">
            <caption>我预定的会议：${result}</caption>
            <tr class="listheader">
                <th>会议名称</th>
                <th>会议室名称</th>
                <th>会议开始时间</th>
                <th>会议结束时间</th>
                <th>会议预定时间</th>
                <th>会议实时状态</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${meetingList}" var="meeting">
            <tr>
                <td>${meeting.meetingname}</td>
                <td>${meeting.meetroom.mrname}</td>
                <td>${meeting.begindate} </td>
                <td>${meeting.enddate}</td>
                <td>${meeting.ordertime}</td>
                <td>${meeting.state}</td>
                <td>
                    <a class="clickbutton" href="showmeetingdetails.action?mtid=${meeting.meetingid}">查看/撤销</a>
                </td>
            </tr>
            </c:forEach>
        </table>
    </div>
</div>
<div class="page-footer">
    <hr/>
    更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
    <img src="images/footer.png" alt="CoolMeeting"/>
</div>
</body>
</html>


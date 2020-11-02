<%--
  Created by IntelliJ IDEA.
  User: kkww
  Date: 2020/10/10
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="page-header">
    <div class="header-banner">
        <img src="images/header.png" alt="CoolMeeting"/>
    </div>
    <div class="header-title">
        欢迎访问Cool-Meeting会议管理系统
    </div>
    <div class="header-quicklink">

        欢迎您，
        <strong>
            <c:if test="${user == null}">
                <%--这里写 login.jsp  都不可以--%>
                <a href="go.action?go=login.jsp">想查看会议信息请先<font color="black">登录</font>哦  </a>
            </c:if>
            <c:if test="${user != null}">
               第${logincount}位登录的 ${user.accountname}
            </c:if>
        </strong>

        <c:if test="${user != null}">
            <a href="logout.action">退出</a>
        <a href="go.action?go=changepassword.jsp">[修改密码]</a>
        </c:if>
    </div>
</div>
</body>
</html>

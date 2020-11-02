<%--
  Created by IntelliJ IDEA.
  User: kkww
  Date: 2020/10/10
  Time: 11:11
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
</head>
<body>
<jsp:include page="head.jsp"/>
<div class="page-body">
    <jsp:include page="hp-sidebar.jsp"/>
    <div class="page-content">
        <div class="content-nav">
            修改密码 <h5><font color="red">${result}
        <c:if test="${login == 'login'}" ><a href="login.jsp">登录</a></c:if>
        </font></h5>
        </div>
        <form action="changepassword.action" method="post">
            <fieldset>
                <legend>修改密码信息</legend>
                <table class="formtable" style="width:50%">
                    <tr>
                        <td>原密码:</td>
                        <td>
                            <input id="origin"  name="oldpassword" type="password" />
                        </td>
                    </tr>
                    <tr>
                        <td>新密码:</td>
                        <td>
                            <input id="new" name="newpassword1" type="password" />
                        </td>
                    </tr>
                    <tr>
                        <td>确认新密码：</td>
                        <td>
                            <input id="confirm" name="newpassword2" type="password"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" class="command">
                            <input type="submit" value="确认修改" class="clickbutton"/>
                            <input type="button" value="返回" class="clickbutton" onclick="window.history.back();"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </form>
    </div>
</div>
<div class="page-footer">
    <hr/>
    更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
    <img src="images/footer.png" alt="CoolMeeting"/>
</div>
</body>
</html>

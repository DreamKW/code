<%--
  Created by IntelliJ IDEA.
  User: kkww
  Date: 2020/10/11
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

    <%--jquery--%>
    <script type="text/javascript" src="jquery/jquery-1.7.2.min.js"></script>
    <script type="application/javascript">
        function judgeEmpty() {
            var accountname = $("#accountname").val();
            $.ajax({
                type: "GET",
                url: "searchEmployeesGet.action",
                data: "accountname="+accountname,
                //这里msg是模板自带的 是servlet out.println的输出值
                success: function(msg){
                    $("#tip").html(msg);
                }
            });
        }
    </script>

    <title>CoolMeeting会议管理系统</title>
    <link rel="stylesheet" href="styles/common.css"/>
    <style type="text/css">
        /*<meta charset = "utf-8"/>*/
    </style>



    <%--ajax--%>
<%--    <script type="text/javascript">
        var xmlhttp

        function judgeEmpty()
        {
            xmlhttp=null
            var accountname = document.getElementById("accountname").value;

// 针对 Mozilla等浏览器的代码：
            if (window.XMLHttpRequest)
            {
                xmlhttp=new XMLHttpRequest()
            }

// 针对 IE 的代码：
            else if (window.ActiveXObject)
            {
                xmlhttp=new ActiveXObject("Microsoft.XMLHTTP")
            }
            if (xmlhttp!=null)
            {
                xmlhttp.onreadystatechange=state_Change
                xmlhttp.open("GET","SearchEmployeesServlet?accountname="+accountname,true)
                xmlhttp.send(null)
            }
            else
            {
                alert("您的浏览器不支持XMLHTTP")
            }
        }

        function state_Change()
        {
// 如果 xmlhttp 显示为 "loaded"
            if (xmlhttp.readyState==4)
            {
                // 如果为 "OK"
                if (xmlhttp.status==200)
                {
                    // 获取到servlet 的响应内容并且显示在页面......
                    document.getElementById("tip").innerHTML = xmlhttp.responseText;
                }
                else
                {
                    alert("Problem retrieving XML data")
                }
            }
        }
    </script>--%>
</head>
<body>
<jsp:include page="head.jsp"/>
<div class="page-body">
    <jsp:include page="hp-sidebar.jsp"/>
    <div class="page-content">
        <div class="content-nav">
            会议预定 > 搜索员工
        </div>
            <fieldset>
                <legend>搜索员工</legend>
                <table class="formtable">
                    <form action="searchEmployees.action" method="post">
                    <tr>
                        <td>账号名：</td>
                        <td>
                            <input width="150px" type="text" value="" id="accountname" name="accountname"  onkeyup="judgeEmpty()" /><font color="red"><span width="330px" id="tip"></span></font>
                        </td>
                        <td  class="command" >
                            <input type="submit" class="clickbutton"  value="查询" />
                            <input type="reset" class="clickbutton" value="重置" />
                        </td>
                    </tr>
                    </form>

                </table>
            </fieldset>
        <div>
            <h3 style="text-align:center;color:black">查询结果</h3><font color="red">${result}</font>
        </div>
        <table class="listtable">
            <tr class="listheader">
                <th>姓名</th>
                <th>账号名</th>
                <th>联系电话</th>
                <th>电子邮件</th>
                <th>操作</th>
            </tr>
            <c:if test="${usersearch != null}">
            <tr>
                <td>${usersearch.username}</td>
                <td>${usersearch.accountname}</td>
                <td>${usersearch.tell}</td>
                <td>${usersearch.email}</td>
                <td>
                    <a class="clickbutton" href="CloseAccountServlet?uid=${usersearch.userid}">关闭账号</a>
                </td>
            </tr>
            </c:if>
        </table>
    </div>
</div>
<div class="page-footer">
    <hr/>
    更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
    <img src="../images/footer.png" alt="CoolMeeting"/>
</div>
</body>
</html>
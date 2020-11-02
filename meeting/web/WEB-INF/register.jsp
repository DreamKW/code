<%--
  Created by IntelliJ IDEA.
  User: kkww
  Date: 2020/10/10
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset = "utf-8"/>
    <title>CoolMeeting会议管理系统</title>
    <link rel="stylesheet" href="styles/common.css"/>
    <style type="text/css">

    </style>

    <script type="text/javascript">
<%--正则表达式--%>
        function judgetell() {
            var phone = document.getElementById("phone").value;
            var regtell = new RegExp("^((13[0-9])|(17[0-1,6-8])|(15[^4,\\\\D])|(18[0-9]))\\d{8}$");
            var tellspan = document.getElementById("tellspan");
            if (!regtell.test(phone)){
                tellspan.innerHTML="请输入正确的电话号";
            }else {
                tellspan.innerHTML="";
            }
        }
        function judgeemail() {
            var email = document.getElementById("email").value;
            var regemail = new RegExp("^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$");
            var spanemail = document.getElementById("emailspan");
            if (!regemail.test(email)){
                spanemail.innerHTML="请输入正确的电子邮件";
            }else {
                spanemail.innerHTML="";
            }
        }


    </script>

    <script type="text/javascript" src="jquery/jquery-1.7.2.min.js"></script>
    <script type="application/javascript">
        function judgepwdsame() {
            var pwd2 = $("#pwd2").val();
            var pwd1 = $("#pwd1").val();
            $.ajax({
                type: "GET",
                url: "registerGet.action",
                data: "pwd2="+pwd2 +"&pwd1="+pwd1,
                //这里msg是模板自带的 是servlet out.println的输出值
                success: function(msg){
                    $("#pwdspan").html(msg);
                }
            });
        }

        function judgeaccountname() {
            var accountname = $("#accountname").val();
            $.ajax({
                type: "GET",
                url: "registerGet.action",
                data: "accountname="+accountname,
                //这里msg是模板自带的 是servlet out.println的输出值
                success: function(msg){
                    $("#accountnamespan").html(msg);
                }
            });
        }
    </script>
</head>
<body>
<jsp:include page="head.jsp" />
<div class="page-body">
    <jsp:include page="hp-sidebar.jsp"/>
    <div class="page-content">
        <div class="content-nav">
            人员管理 > 员工注册
        </div>
        <form action="register.action" method="post">
            <fieldset>
                <legend>员工信息 <font color="red">${result}</font></legend>
                <table class="formtable" style="width:50%">
                    <tr>
                        <td width="100px">姓名：</td>
                        <td width="320px">
                            <input type="text" id="employeename"  name="username" maxlength="20"/>
                        </td>
                    </tr>
                    <tr>
                        <td width="100px">账户名：</td>
                        <td width="320px">
                            <input type="text" id="accountname" onkeyup="judgeaccountname()" name="accountname" maxlength="20"/>
                            <font color="red"><span id="accountnamespan"></span></font>
                        </td>
                    </tr>
                    <tr>
                        <td width="100px">密码：</td>
                        <td width="320px">
                            <input type="password" id="pwd1" name="password1" maxlength="20" placeholder=""/>
                        </td>
                    </tr>
                    <tr>
                        <td>确认密码：</td>
                        <td width="320px">
                            <input  type="password" id="pwd2" name="password2" onkeyup="judgepwdsame()" maxlength="20"/>
                            <font color="red"><span id="pwdspan"></span></font>
                        </td>
                    </tr>
                    <tr>
                        <td width="100px">联系电话：</td>
                        <td width="320px">
                            <input type="text" id="phone" onkeyup="judgetell()" name="tell" maxlength="20"/>
                            <font color="red"><span id="tellspan"></span></font>
                        </td>
                    </tr>
                    <tr>
                        <td width="100px">电子邮件：</td>
                        <td width="400px">
                            <input type="text" id="email"  name="email" onkeyup="judgeemail()" maxlength="20"/>
                            <font color="red"><span id="emailspan"></span></font>
                        </td>
                    </tr>
                    <td width="100px">所在部门：</td>
                    <td>
                        <select name="deptid">
                            <c:forEach items="${departmentList}" var="dep">
                            <option value="${dep.depid}">${dep.depname}</option>
                            </c:forEach>
                        </select>
                    </td>
                    </tr>
                    <tr>
                        <td colspan="6" class="command">
                            <input type="submit" class="clickbutton" value="注册"/>
                            <input type="reset" class="clickbutton" value="重置" onclick=""/>
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

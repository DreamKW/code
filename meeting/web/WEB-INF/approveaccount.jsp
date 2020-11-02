<%--
  Created by IntelliJ IDEA.
  User: kkww
  Date: 2020/10/10
  Time: 15:24
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
    <script type="text/javascript">
        //审批
        function approve(userid) {
            var myform = document.getElementById("Approve");
            myform.action = "approveAccount.action?userid="+userid;
            myform.method = "post";
            myform.submit();

        }
        //删除审批
        function  apprpveDelUser(userid) {
            var myform = document.getElementById("Approve");
            myform.action = "removeAccount.action?userid="+userid;
            myform.method = "post";
            myform.submit();
        }
        //下一页
        function nextPage(next) {
            var pageform = document.getElementById("pageform")
            pageform.action = "showApproveAccount.action?page="+next;
            pageform.method = "post";
            pageform.submit();

        }
        //最后一页
        function lastPage(last) {
            var pageform = document.getElementById("pageform")
            pageform.action = "showApproveAccount.action?page="+last;
            pageform.method = "post";
            pageform.submit();

        }
        //跳转到
        function jumpto() {
            var pageform = document.getElementById("pageform")
            var pagejump = document.getElementById("pagenum").value;
            pageform.action = "showApproveAccount.action?page="+pagejump;
            pageform.method = "post";
            pageform.submit();
        }
        function judgeNo() {
            // alert("asdf")
            var pagenum = document.getElementById("pagenum").value;
            var reg3 = new RegExp("^[0-9]*$");
            var myspan = document.getElementById("myspan");
            //校验电话号
            if(!reg3.test(pagenum)){
                alert("请输入正确的页码");
                myspan.innerHTML = "请输入正确的页码";
                // new Dialog({mode: "tips", tipsType: "error", content: myspan.innerHTML = "adffas"});
                // return false;
            }else {
                myspan.innerHTML = "";
            }
        }

    </script>
</head>
<body>
<jsp:include page="head.jsp"/>
<div class="page-body">
    <jsp:include page="hp-sidebar.jsp"/>
    <div class="page-content">
        <div class="content-nav">
            人员管理 > 注册审批
        </div>
        <div>
            <h2 style="text-align:center;color:black">所有待审批注册信息：</h2>
            <div class="pager-header">
                <div class="header-info">
                    共<span class="info-number">${size}</span>条结果，
                    分成<span class="info-number">${allpage}</span>页显示，
                    <c:if test="${page <= allpage}">
                        当前第<span class="info-number">${page}</span>页
                    </c:if>
                   <font color="red"> ${invalidpage}<span id="myspan"></span></font>
                </div>
                <form id="pageform">
                <div class="header-nav">
                    <%--<input type="button" class="clickbutton" value="首页" onclick="firstPage(${first})"/>--%>
                    <%--<input type="button" class="clickbutton" value="上页" onclick="upPage(${up})"/>--%>
                    <a class="clickbutton" href="showApproveAccount.action?page=${first}">首页</a>
                        <c:if test="${page > 1}">
                            <a class="clickbutton" href="showApproveAccount.action?page=${up}">上页</a>
                        </c:if>

                        <c:if test="${page <= 1}">
                            <a class="clickbutton" href="javascript:void(0)">上页</a>
                        </c:if>
                        <c:if test="${page >= allpage}">
                            <input type="button" class="clickbutton" disabled="disabled" value="下页" onclick="nextPage(${next})"/>
                        </c:if>


                        <c:if test="${page < allpage}">
                            <input type="button" class="clickbutton" value="下页" onclick="nextPage(${next})"/>
                        </c:if>
                    <input type="button" class="clickbutton" value="末页" onclick="lastPage(${last})"/>
                    跳到第<input type="text" id="pagenum" class="nav-number" onkeyup="judgeNo()"/>页
                    <input type="button" class="clickbutton" value="跳转" onclick="jumpto()" />
                </div>
                </form>
            </div>
        </div>
        <table class="listtable">
            <%--<caption>所有待审批注册信息：</caption>--%>

            <h5><font color="red">${result}</font></h5>
            <tr class="listheader">
                <th>姓名</th>
                <th>账号名</th>
                <th>联系电话</th>
                <th>电子邮件</th>
                <th>操作</th>
            </tr>
            <form id="Approve">
            <c:forEach items="${userList}" var="user">
            <tr>
                <td>${user.username}</td>
                <td>${user.accountname}</td>
                <td>${user.tell}</td>
                <td>${user.email}</td>
                <td>
                    <input type="button" class="clickbutton" value="通过" onclick="approve(${user.userid})"/>
                    <input type="button" class="clickbutton" value="删除" onclick="apprpveDelUser(${user.userid})"/>
                </td>
            </tr>
            </c:forEach>
            </form>

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

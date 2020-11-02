<%--
  Created by IntelliJ IDEA.
  User: kkww
  Date: 2020/10/14
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>CoolMeeting会议管理系统</title>
    <link rel="stylesheet" href="../styles/common.css"/>
    <style type="text/css">

    </style>
    <script type="text/javascript">
        function judge() {
            var meetingname = document.getElementById("meetingname").value;
            var roomname = document.getElementById("roomname").value;
            var reservername = document.getElementById("reservername").value;
            var reservefromdate = document.getElementById("reservefromdate").value;
            var reservetodate = document.getElementById("reservetodate").value;
            var meetingfromdate = document.getElementById("meetingfromdate").value;
            var meetingtodate = document.getElementById("meetingtodate").value;

            if (
                meetingname == '' || roomname == '' || reservername == ''|| reservefromdate== ''|| reservetodate== ''|| meetingfromdate== ''|| meetingtodate== ''
            ) {
                alert("信息要全部填写哦");
                return false;
            }else {
                return true;
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
            会议预定 > 搜索会议
        </div>
        <form action="SearchMeetingServlet" method="post">
            <fieldset>
                <legend>搜索会议</legend>
                <table class="formtable">
                    <tr>
                        <td>会议名称：</td>
                        <td>
                            <input type="text" name="meetingname" id="meetingname" maxlength="20"/>
                        </td>
                        <td>会议室名称：</td>
                        <td>
                            <input type="text" id="roomname" name="roomname" maxlength="20"/>
                        </td>
                        <td>预定者姓名：</td>
                        <td>
                            <input type="text" id="reservername"  name="reservername" maxlength="20"/>
                        </td>
                    </tr>
                    <tr>
                        <td>预定日期：</td>
                        <td colspan="5">
                            从&nbsp;<input type="date" id="reservefromdate" name="reservefromdate" placeholder="例如：2013-10-20"/>
                            到&nbsp;<input type="date" id="reservetodate" name="reservetodate" placeholder="例如：2013-10-22"/>
                        </td>
                    </tr>
                    <tr>
                        <td>会议日期：</td>
                        <td colspan="5">
                            从&nbsp;<input type="date" id="meetingfromdate"  name="meetingfromdate" placeholder="例如：2013-10-20"/>
                            到&nbsp;<input type="date" id="meetingtodate"  name="meetingtodate" placeholder="例如：2013-10-22"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="6" class="command">
                            <input type="submit" class="clickbutton" value="查询" onclick="return judge()"/>
                            <input type="reset" class="clickbutton" value="重置"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </form>
        <div>
            <h3 style="text-align:center;color:black">查询结果</h3>
            <div class="pager-header">
                <div class="header-info">
                    共<span class="info-number">16</span>条结果，
                    分成<span class="info-number">4</span>页显示，
                    当前第<span class="info-number">1</span>页
                </div>
                <div class="header-nav">
                    <input type="button" class="clickbutton" value="首页"/>
                    <input type="button" class="clickbutton" value="上页"/>
                    <input type="button" class="clickbutton" value="下页"/>
                    <input type="button" class="clickbutton" value="末页"/>
                    跳到第<input type="text" id="pagenum" class="nav-number"/>页
                    <input type="button" class="clickbutton" value="跳转"/>
                </div>
            </div>
        </div>
        <table class="listtable">
            <tr class="listheader">
                <th>会议名称</th>
                <th>会议室名称</th>
                <th>会议开始时间</th>
                <th>会议结束时间</th>
                <th>会议预定时间</th>
                <th>预定者</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${meetingList}" var="meeting">
            <tr>
                <td>${meeting.meetingname}</td>
                <td>${meeting.meetroom.mrname}</td>
                <td>${meeting.begindate}</td>
                <td>${meeting.enddate}</td>
                <td>${meeting.ordertime}</td>
                <td>${meeting.user.username}</td>
                <td>
                    <a class="clickbutton" href="ShowmeetingdetailsServlet?mtid=${meeting.meetingid}">查看详情</a>
                </td>
            </tr>
            </c:forEach>

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


<%--
  Created by IntelliJ IDEA.
  User: kkww
  Date: 2020/10/11
  Time: 19:36
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
    <script type="text/javascript">

        <%--设置为可编辑的 即删除 部门名称 input 的 disabled属性即可  --%>
        function disabledme(depid) {
            var surebutton = document.getElementById("surebutton"+depid.toString());
            var b = document.getElementById(depid);
            surebutton.removeAttribute("disabled");
            b.removeAttribute("disabled");

        }
        //确认编辑按钮
        function undisabled(depid) {
            // var b = document.getElementById(depid)
            // 在这里设置disabled 属性 必须要有第二个参数 为""  "false"  获取其他 只要有第二个参数 就为disabled
            //修改以后跳转到 showdepServlet 页面 页面重新刷新  确定按钮 默认就为 disabled (html中设置)
            // b.setAttribute("disabled","disabled");
            var addDepform = document.getElementById("updatedepnameform"+depid.toString());
            addDepform.action="updateDep.action?depid="+depid;
            addDepform.method="POST";
            addDepform.submit();
        }
        function addDep() {
                var addDepform = document.getElementById("addDepform");
                addDepform.action="addDep.action";
                addDepform.method="post";
                addDepform.submit();
        }
        //  如果为空 则 添加 按钮无效
        function judgeEmpty() {
            var depname = document.getElementById("departmentname").value;
            var  adddepbutton = document.getElementById("adddepbutton");
            if (depname =='' || depname == ' '){
                adddepbutton.setAttribute("disabled","disabled");
            }else {
                adddepbutton.removeAttribute("disabled");
            }
        }
//        用ajax 判断部门名称是否为空



/*        var xmlhttp

        function judgeEmpty()
        {
            xmlhttp=null
            var depname = document.getElementById("departmentname").value;


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
                xmlhttp.open("GET","AddDepServlet?depname="+depname,true)
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
                    // 其他代码...
                    document.getElementById("tip").innerHTML = xmlhttp.responseText;
                }
                else
                {
                    alert("Problem retrieving XML data")
                }
            }
        }*/


    </script>
</head>
<body>
<jsp:include page="head.jsp"/>
<div class="page-body">
    <jsp:include page="hp-sidebar.jsp"/>
    <div class="page-content">
        <div class="content-nav">
            人员管理 > 部门管理
        </div>
        <form id="addDepform">
            <fieldset>
                <legend>添加部门</legend>
                部门名称:
                <%--onblur="judgeEmpty()"--%>
                <input type="text" id="departmentname" onkeyup="judgeEmpty()" placeholder="名称不能为空哦" name="departmentname"  value="" maxlength="20"/>
                <input type="submit" class="clickbutton" disabled  id="adddepbutton" name="adddepbutton" value="添加" onclick="addDep()"/>
                <font color="red">
                    ${result}
                    <c:if test="${result == null }">
                        <span id="tip"></span>
                    </c:if>
                </font>
            </fieldset>
        </form>
        <table class="listtable">
            <caption>所有部门:</caption>
            <tr class="listheader">
                <th>部门编号</th>
                <th>部门名称</th>
                <th>操作</th>
            </tr>
                <c:forEach items="${departmentList}" var="department">
                    <form   id="updatedepnameform${department.depid}">

                            <tr>
                                <td>${department.depnum}</td>
                                <td>
                                    <input type="text" name="newdepname" id="${department.depid}" value="${department.depname}" disabled/>
                                </td>
                                <td>
                                    <a class="clickbutton"   onclick="disabledme(${department.depid})">编辑</a>
                                    <input type="button" id="surebutton${department.depid}" disabled class="clickbutton" onclick="undisabled(${department.depid})"  value="确定">
                                    <%--<a class="clickbutton"  onclick="undisabled(${department.depid})">确定</a>--%>
                                    <a class="clickbutton"  href="delDep.action?depid=${department.depid}">删除</a>
                                </td>
                            </tr>
                    </form>
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
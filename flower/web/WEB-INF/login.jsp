<%--
  Created by IntelliJ IDEA.
  User: kkww
  Date: 2020/9/17
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<!-- Head -->
<head>

    <title>登录表单</title>

    <!-- Meta-Tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- //Meta-Tags -->

    <!-- Style --> <link rel="stylesheet" href="css/style.css" type="text/css" media="all">

    <script type="text/javascript">
        var xmlhttp

        function judge()
        {
            xmlhttp=null
//            定义一个变量用来接受输入的用户名
            var uname = document.getElementById("uname").value;

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
            {  //定义回调函数 即如下的函数 名称为state_Change

                xmlhttp.onreadystatechange=state_Change
                xmlhttp.open("GET","registerServet?uname="+uname,true)
                //open 的第三个参数为 true 表明他是异步
                // 那么脚本处理会在 send() 方法之后得到继续，不会等待某个响应。
                // 如果设定为 false，那么在继续脚本处理之前，脚本会等待某个响应。
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
                    // 获取到servlet 的响应内容并且显示在页面...
                    document.getElementById("tip").innerHTML = xmlhttp.responseText;
                }
                else
                {
                     alert("Problem retrieving XML data")
                }
            }
        }
    </script>
</head>
<!-- //Head -->

<!-- Body -->
<body>

<h1>登录表单</h1>

<div class="container w3layouts agileits">

    <div class="login w3layouts agileits">
        <h2>登 录 </h2><H6>${result}</H6>
        <form action="login.action?type=${type}" method="post">
            <input type="text" Name="Userame" placeholder="用户名"  required="">
            <input type="password" Name="Password" placeholder="密码" required="">
            <select name ="role">
                <option value="管理员">管理员</option>
                <option value="VIP">VIP</option>
                <option value="普通用户">普通用户</option>
            </select>

            <div class="send-button w3layouts agileits">

                <input type="submit" value="登 录">

            </div>
        </form>
        <ul class="tick w3layouts agileits">
            <li>
                <input type="checkbox" id="brand1" value="">
            </li>
        </ul>

        <a href="main.html">返回主页</a>

        <div class="clear"></div>
    </div><div class="copyrights">Collect from <a href="" ></a></div>
    <div class="register w3layouts agileits">
        <h2>注 册</h2>
        <form >
            <input type="text" Name="Name" id="uname" placeholder="用户名" onkeyup="judge()" required="">
            <span id="tip"></span>
            <input type="text" Name="Email" id="email" placeholder="邮箱" required="">
            <input type="password" Name="Password1" id="password1" placeholder="密码" required="">
            <input type="password" Name="Password2" id="password2" placeholder="确认密码" required="">
            <input type="text" Name="Phone Number" id="tell" placeholder="手机号码" required="">
        </form>
        <div class="send-button w3layouts agileits">
            <form>
                <input type="submit" value="免费注册">
            </form>
        </div>
        <div class="clear"></div>
    </div>

    <div class="clear"></div>
</div>
</body>
<!-- //Body -->

</html>

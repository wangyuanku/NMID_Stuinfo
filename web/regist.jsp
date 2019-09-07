<%--
  Created by IntelliJ IDEA.
  User: 50462
  Date: 2019/9/7
  Time: 0:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*" contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+ "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Regist</title>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#form1").submit(function () {
                var username=$("#username").val();//获取提交的账户
                }
                //确认密码验证
                var password=$("#password").val();//获取提交的密码
                var relpassword=$("#relpassword").val();//获取提交的确认密码
                if (password != relpassword){
                    $("#relpasswordError").html("确认密码错误");
                    return false;
            })
        })
    </script>
</head>
<body>
<form action="regist" method="post" id="form1">
    <h1>用户注册页面</h1>
    <table align="center">
        <tr>
            <td>账号</td>
            <td>
                <input type="text" name="username" id="username"/>
            </td>
        </tr>
        <tr>
            <td>密码</td>
            <input type="password" name="password" id="password"/>
        </tr>
        <tr>
            <td>确认密码</td>
            <input type="password" name="password" id="password"/>
            <div id="relpasswordError" style="display: inline;color:red;"></div>
        </tr>
        <tr>
            <td colspan="1"></td>
            <td>
                <input type="submit" value="注册">
                <input type="reset" value="重制">
                <a href="index.jsp" target="_blank">登录</a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>

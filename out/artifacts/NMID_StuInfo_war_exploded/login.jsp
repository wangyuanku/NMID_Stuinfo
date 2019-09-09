<%--
  Created by IntelliJ IDEA.
  User: 50462
  Date: 2019/9/7
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+ "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>login</title>
</head>
<body>
<form action="login" method="post">
    <h1>用户登录界面</h1>
    <table align = "left">
        <tr>
            <td>账号</td>
            <td><input type="text" name="username" id="username"></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password" id="password"></td>
        </tr>
        <tr>
            <td colspan="1"></td>
            <td>
                <input type="submit" value="登录"/>
                <a href="regist.jsp" target="_blank">注册</a>
                <td><font color="red">${error}</font> </td>
            </td>
        </tr>
    </table>
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: 50462
  Date: 2019/9/7
  Time: 0:11
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
    <title>main</title>
</head>
<body>
<p>登录成功</p>
<br>当前用户：${currentUser.username}<br/>
<br>当前密码：${currentUser.password}<br/>
</body>
</html>

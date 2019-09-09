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
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>main</title>
    <script type="text/javascript">
        function show() {
            var url = "insert.jsp"
            var open = window.open(url,"","width=200, height=100");
            open.focus();
        }
        // function Delete() {
        //     var flag = confirm("确定删除？");
        //     if (flag){
        //         location.href="delete?name="+name;
        //     }
        // }
        function Delete(){
            var url = "delete.jsp";
            var open = window.open(url);
            open.focus();
        }
    </script>
    
</head>
<body>
<p>登录成功   当前用户：${currentUser.username}</p>
<p><input type="button" onclick="show()" value="添加学生"></p>
<form action="search" method="post">
<table border="1" width="700">
    <tr>
        <td colspan="8">
            按姓名查询：<input type="text" name="name">
            <input type="submit" value="查询">
        </td>
    </tr>
    <tr align="center">
        <td>学号</td>
        <td>姓名</td>
        <td>性别</td>
        <td>年龄</td>
        <td>出生日期</td>
        <td>操作</td>
    </tr>

    <c:forEach items="${list}" var="student">
        <tr align="center">
            <td>${student.stuID}</td>
            <td>${student.name}</td>
            <td>${student.gender}</td>
            <td>${student.age}</td>
            <td>${student.birthday}</td>
            <td><a onclick="Delete()">删除</a></td>
        </tr>
    </c:forEach>
</table>
</form>

</body>
</html>

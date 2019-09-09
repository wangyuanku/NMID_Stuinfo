<%--
  Created by IntelliJ IDEA.
  User: 50462
  Date: 2019/9/9
  Time: 8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>InsertNewStudent</title>
</head>
<body>
<form action="insert" method="post">
    <table>
        <tr>
            <td colspan="2">添加界面</td>
        </tr>
        <tr>
            <td>学号：</td>
            <td><input type="text" name="stuid" id="stuid"></td>
        </tr>
        <tr>
            <td>姓名：</td>
            <td><input type="text" name="name" id="name"></td>
        </tr>
        <tr>
            <td>性别：</td>
            <td><input type="text" name="gender" id="gender"></td>
        </tr>
        <tr>
            <td>年龄：</td>
            <td><input type="text" name="age" id="age"></td>
        </tr>
        <tr>
            <td>出生日期：</td>
            <td><input type="text" name="birthday" id="birthday"></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"></td>
            <td><font color="red">${error}</font> </td>
        </tr>
    </table>
</form>
</body>
</html>

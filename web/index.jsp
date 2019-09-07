<%--
  Created by IntelliJ IDEA.
  User: 50462
  Date: 2019/9/5
  Time: 23:07
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
                  <td><input type="text" name="password" id="password"></td>
              </tr>
              <tr>
                  <td colspan="1"></td>
                  <td>
                      <input type="submit" value="登录"/>
                      <input type="reset" value="重制/">
                      <a href="regist.jsp" target="_blank">注册</a>
                  </td>
              </tr>
          </table>
  </form>
  </body>
</html>

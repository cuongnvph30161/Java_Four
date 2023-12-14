<!-- <%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/4/2023
  Time: 11:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
-->

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>
<body>
<form action="
<%= request.getContextPath()
%>/SiteController" method="post">
    UserName: <input type="text" name="username"> <br>
    Password: <input type="password" name="password"><br>
    <input type="hidden" name="action" value="loginSubmit">
    <input type="submit" value="submit">
</form>
</body>
</html>
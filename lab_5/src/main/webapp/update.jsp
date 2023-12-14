<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/20/2023
  Time: 11:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="bootstrap.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Update</title>
</head>
<body class="container" style="width: 500px;">
<h1></h1>
<form method="post">

    <input type="hidden" name="id" value="${user.id}" class="form-control" id="exampleInputEmail1"
           aria-describedby="emailHelp">

    <div class="mb-3">
        <label class="form-label">Password</label>
        <input type="password" name="password" value="${user.password}" class="form-control">
    </div>

    <div class="mb-3">
        <label class="form-label">FullName</label>
        <input type="text" value="${user.fullname}" name="fullname" class="form-control">
    </div>

    <div class="mb-3">
        <label class="form-label">Email</label>
        <input type="email" value="${user.email}" name="email" class="form-control">
    </div>

    <div class="mb-3">
        <label class="form-label">Admin</label>
        <input class="form-check-input" name="admin" type="checkbox" ${user.admin?"checked":""} value="true"
               id="defaultCheck1">
    </div>

    <button formaction="update" type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>

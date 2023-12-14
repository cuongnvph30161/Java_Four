<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/14/2023
  Time: 9:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body class="container" style="width: 500px">
<h1 style="text-align: center">Update Detail</h1>

<form method="post">
    <input type="hidden" name="id" value="${user.id}">
    <div class="mb-3">
        <label for="email" class="form-label">Email</label>
        <input type="email" name="email" class="form-control" id="email" value="${user.email}">
    </div>
    <div class="mb-3">
        <label for="fullname" class="form-label">Fullname</label>
        <input type="text" name="fullname" class="form-control" id="fullname" value="${user.fullname}">
    </div>

    <div class="mb-3">
        <label class="form-label">Admin:</label>
        <input class="form-check-input" name="admin" type="checkbox" ${user.admin?"checked" : ""}
               id="defaultCheck1">
    </div>
    <button formaction="update" type="submit" class="btn btn-primary">Save</button>

</form>
</body>
</html>

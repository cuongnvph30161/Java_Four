<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
<html>
<head>
    <title>Title</title>
</head>
<body class="container" style="width: 1000px">
<h1 style="text-align: center;">Quản lý người dùng</h1>
<table class="table" style="margin-top: 50px">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Password</th>
        <th scope="col">Email</th>
        <th scope="col">Fullname</th>
        <th scope="col">Country</th>
        <th scope="col">Gender</th>
        <th scope="col">Admin</th>
        <th scope="col">Details</th>

    </tr>
    </thead>
    <c:forEach items="${listUser}" var="user">
        <tbody>
        <tr>
            <th scope="row">${user.id}</th>
            <td>${user.password}</td>
            <td>${user.email}</td>
            <td>${user.fullname}</td>
            <td>${user.country}</td>
            <td>${user.gender}</td>
            <td>
                <c:if test="${user.admin}">Admin</c:if>
                <c:if test="${!user.admin}">User</c:if>
            </td>
            <td>
                <a href="update?id=${user.id}">
                    <button type="button" class="btn btn-primary">Update</button>
                </a>
                <a href="delete?id=${user.id}">
                    <button type="button" class="btn btn-warning">Delete</button>
                </a>
            </td>

        </tr>
        </tbody>
    </c:forEach>
</table>
<a href="/asm_1_war_exploded/add.jsp">
    <button type="button" class="btn btn-success">Add User</button>
</a>
</body>
</html>

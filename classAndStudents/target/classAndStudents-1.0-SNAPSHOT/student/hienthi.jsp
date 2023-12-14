<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/21/2023
  Time: 4:40 PM
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
    <title>Bảng Danh Sách Student</title>
</head>
<body>
<table class="table">
    <thead>
    <h1>Danh Sách Sinh Viên</h1>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Tên</th>
        <th scope="col">Tên Lớp</th>
        <th scope="col">Địa Chỉ</th>
        <th scope="col">Giới Tính</th>
        <th scope="col">Chiều Cao</th>
        <th scope="col">Cân Nặng</th>
        <th scope="col">Functions</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listStudents}" var="student">
        <tr>
            <td>${student.id}</td>
            <td>${student.ten}</td>
            <td>${student.lop.tenLop}</td>
            <td>${student.diaChi}</td>
            <td>${student.gioiTinh}</td>
            <td>${student.chieuCao}</td>
            <td>${student.canNang}</td>

            <td>

                <a href="view-update-student?id=${student.id}">
                    <button type="button" class="btn btn-primary">Update</button>
                </a>

                <a href="delete-student?id=${student.id}">
                    <button type="button" class="btn btn-warning">Delete</button>
                </a>

            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="view-create-student">
    <button type="button" class="btn btn-danger">Add Student</button>
</a>
</body>
</html>

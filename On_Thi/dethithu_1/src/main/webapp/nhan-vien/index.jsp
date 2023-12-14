<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/24/2023
  Time: 10:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Danh Sach</title>
</head>
<body>
<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Mã</th>
        <th scope="col">Tên</th>
        <th scope="col">Giới tính</th>
        <th scope="col">Địa chỉ</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="nhanvien">
        <tr>
            <td>${nhanvien.id}</td>
            <td>${nhanvien.manv}</td>
            <td>${nhanvien.hoten}</td>
            <td>${nhanvien.gioitinh}</td>
            <td>${nhanvien.diachi}</td>
            <td>
<a href=""><button></button></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

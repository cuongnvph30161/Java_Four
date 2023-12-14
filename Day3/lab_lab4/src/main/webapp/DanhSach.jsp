<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/17/2023
  Time: 10:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
<html>
<head>
    <title>danh sach</title>
</head>
<body>
<body class="container" style="width: 1000px">
<h1 style="text-align: center;">Danh Sách</h1>
<table class="table" style="margin-top: 50px">
    <thead>
    <tr>
        <th scope="col">Tên sản phẩm</th>
        <th scope="col">Đơn giá</th>
        <th scope="col">Loại sản phẩm</th>
        <th scope="col">Còn hàng</th>
    </tr>
    </thead>
    <c:forEach items="${listSanPham}" var="sp">
        <tbody>
        <tr>
            <th scope="row">${sp.tensanpham}</th>
            <td>${sp.loaisanpham}</td>
            <td>${sp.dongia}</td>


            <td>
                <c:if test="${sp.conhang}">Còn</c:if>
                <c:if test="${!sp.conhang}">Hết</c:if>
            </td>


        </tr>
        </tbody>
    </c:forEach>
</table>
<a href="add">
    <button type="button" class="btn btn-success">Add User</button>
</a>
</body>
</html>

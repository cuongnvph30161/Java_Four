<%--
  Created by IntelliJ IDEA.
  User: THE ANH
  Date: 11/15/2023
  Time: 4:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
<head>
    <title>Title</title>
</head>
<body>

<table border="1" class="table">
    <thead>
    <th>ID</th>
    <th>Loại cây</th>
    <th>Tên</th>
    <th>Số tuổi</th>
    <th>Giới tính</th>
    <th>Khu Vực</th>
    <th>Action</th>
    </thead>
    <c:forEach var="i" items="${listThucVat}" varStatus="thucVat">
        <tr>
            <td>${i.id}</td>
            <td>${i.loaiCay}</td>
            <td>${i.ten}</td>
            <td>${i.tuoi}</td>
            <td>${i.gioiTinh ? 'Đực' : 'Cái'}</td>
            <td>${i.khuVuc}</td>
            <td >
                <a href="url-cua-chi-tiet">Detail</a>
                <button >Edit</button>
                <a href="/thuc-vat/remove?vitri=${thucVat.index}">Remove</a>
                </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
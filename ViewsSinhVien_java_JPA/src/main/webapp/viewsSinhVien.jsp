<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
            rel="stylesheet"
    />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">

    <div class="bg-primary text-white mt-5 p-2">
        <h4>List Students</h4>
    </div>

    <a href="/Students/add" class="">
        <button class="btn btn-success mt-2 mb-2">Add Students</button>
    </a>

    <table class="table table-bordered" border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>gender</th>
            <th>class</th>
            <th>Location</th>
            <th>weight</th>

        </tr>

        <c:forEach items="${listSinhVien}" var="i">
            <tr>
                <td>${i.id}</td>
                <td>${i.hoTen}</td>
                <td>
                    <c:if test="${i.gioiTinh=='Male'}">Male</c:if>
                    <c:if test="${i.gioiTinh=='Female'}">Female</c:if>

                </td>
                <td>${i.lop.tenLop}</td>
                <td>${i.diaChi}</td>
                <td>${i.canNang}</td>

                <td>
                    <a href="/Students/detail?id=${i.id}">
                        <button class="btn btn-primary">detail</button>
                    </a>

                    <a href="/Students/update?id=${i.id}">
                        <button class="btn btn-outline-secondary">Update</button>
                    </a>


                    <button onclick="showMess(${i.id})" class="btn btn-danger">Remove</button>

                </td>
            </tr>
        </c:forEach>
    </table>

</div>

</body>
</html>

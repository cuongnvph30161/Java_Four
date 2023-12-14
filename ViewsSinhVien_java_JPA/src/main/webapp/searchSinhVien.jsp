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
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02"
            aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-6 col-sm-6">
            <li class="nav-item active">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Link</a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="#">Disabled</a>
            </li>
        </ul>
        <form action="/sinhVien/search" method="get">
            <input class="form-control mr-sm-2 col-sm-6" name="txtname" type="search" placeholder="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>
<div class="container">

    <div class="bg-primary text-white mt-5 p-2">
        <h4>List Students</h4>
    </div>

    <a href="/sinhVien/add" class="">
        <button class="btn btn-success mt-2 mb-2">Add Students</button>
    </a>

    <table class="table table-bordered" border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>gender</th>
            <th>class</th>
            <th>Location</th>
            <th>height</th>
            <th>weight</th>

        </tr>

        <c:forEach items="${listSearch}" var="i">

            <tr>
                <td>${i.id}</td>
                <td>${i.hoTen}</td>
                <td>
                    <c:if test="${i.gioiTinh=='Male'}">Male</c:if>
                    <c:if test="${i.gioiTinh=='Female'}">Female</c:if>

                </td>
                <td>${i.lop.tenLop}</td>
                <td>${i.diaChi}</td>
                <td>${i.chieuCao}</td>
                <td>${i.canNang}</td>

                <td>
                    <a href="/Students/detail?id=${i.id}">
                        <button class="btn btn-primary">detail</button>
                    </a>

                    <a href="/Students/update?id=${i.id}">
                        <button class="btn btn-outline-secondary">Update</button>
                    </a>


                    <a href="/sinhVien/delete?id=${i.id}">
                        <button class="btn btn-danger">Remove</button>

                    </a>
                </td>
            </tr>

        </c:forEach>
    </table>

</div>
</form>

</body>
</html>

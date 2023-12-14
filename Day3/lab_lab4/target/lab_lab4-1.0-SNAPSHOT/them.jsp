<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/17/2023
  Time: 11:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<h1 style="text-align: center">User Detail</h1>
<form method="post">
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Tên</label>
        <input type="text" name="ten" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
    </div>


    <div class="mb-3">
        <label class="form-label">Loại</label>
        <select name="loai" class="form-select" aria-label="Default select example">
            <option value="IP">IP</option>
            <option value="SS">SS</option>
            <option value="GALA">GALA</option>
        </select>
    </div>

    <div class="mb-3">
        <label class="form-label">Đơn giá:</label>
        <input type="text" name="gia" class="form-control" aria-describedby="emailHelp">
    </div>
    <div class="mb-3">
        <label class="form-label">Còn hàng:</label>
        <input class="form-check-input" name="conhang" type="checkbox" value="true"
               id="defaultCheck1">
    </div>

    <button formaction="add" type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>

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
    <title>Title</title>
</head>
<body>
<h1 style="text-align: center">Thêm sinh viên</h1>
<form method="post">
    <div class="mb-3">
        <label class="form-label">Tên Sinh Viên</label>
        <input type="text" name="tensinhvien"  class="form-control">
    </div>
    <div class="mb-3">
        <label class="form-label">Tên Lớp</label>
        <input type="text" name="tenLop" class="form-control">
    </div>
    <div class="mb-3">
        <label class="form-label">Địa chỉ</label>
        <input type="text" name="diachi" class="form-control">
    </div>
    <div class="mb-3">
        <label class="form-label">Giới tính</label>
        <input type="text" name="gioitinh" class="form-control">
    </div>
    <div class="mb-3">
        <label class="form-label">Chiều Cao</label>
        <input type="text" name="chieucao" class="form-control">
    </div>
    <div class="mb-3">
        <label class="form-label">Cân Nặng</label>
        <input type="text" name="cannang" class="form-control">
    </div>
    <button formaction="create-student" type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>

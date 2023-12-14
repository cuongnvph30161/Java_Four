<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/14/2023
  Time: 9:26 PM
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
<h1 style="text-align: center">User Detail</h1>
<form method="post">
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Id</label>
        <input type="text" name="id" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
        <p style="color: #ff0000;">${validateTrungIdUser}</p>
    </div>
    <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">Password</label>
        <input type="password" name="password" class="form-control" id="exampleInputPassword1">
    </div>
    <div class="mb-3">
        <label for="email" class="form-label">Email</label>
        <input type="email" name="email" class="form-control" id="email">
    </div>
    <div class="mb-3">
        <label for="fulllname" class="form-label">Fullname</label>
        <input type="text" name="fullname" class="form-control" id="fulllname">
    </div>
    <div class="mb-3">
        <label for="fulllname" class="form-label">Country</label>
        <select name="country" class="form-select" aria-label="Default select example">
            <option value="VietNam">VietNam</option>
            <option value="ThaiLand">ThaiLand</option>
            <option value="USA">USA</option>
        </select>
    </div>
    <div class="mb-3">
        <label for="fulllname" class="form-label">Gender</label>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="gender" value="Nam" id="flexRadioDefault1">
            <label class="form-check-label" for="flexRadioDefault1">
                Nam
            </label>
        </div>

        <div class="form-check">
            <input class="form-check-input" type="radio" name="gender" value="Nữ" id="flexRadioDefault2" checked>
            <label class="form-check-label" for="flexRadioDefault2">
                Nữ
            </label>
        </div>
    </div>

    <div class="mb-3">
        <label class="form-label">Admin:</label>
        <input class="form-check-input" name="admin" type="checkbox" value="true"
               id="defaultCheck1">
    </div>

    <button formaction="/asm_1_war_exploded/add" type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>

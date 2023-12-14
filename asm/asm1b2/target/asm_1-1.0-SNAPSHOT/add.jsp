<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/18/2023
  Time: 3:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>

<html>
<head>
    <title>Movie</title>
</head>
<body class="container" style="width: 500px">
<h1 style="text-align: center">Movie Detail</h1>
<form action="add" method="post" enctype="multipart/form-data">

    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Id</label>
        <input type="text" name="id" class="form-control"  required id="exampleInputEmail1" aria-describedby="emailHelp">
            <p style="color: #ff0000;">${validateTrungIdMovie}</p>
    </div>

    <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">Title</label>
        <input type="text" name="title" required class="form-control" id="exampleInputPassword1">
    </div>

    <div class="mb-3">
        <label for="email" class="form-label">Description</label>
        <textarea name="description" required class="form-control" id="email"></textarea>
    </div>

    <div class="mb-3">
        <label class="form-label">Active:</label>
        <input class="form-check-input"  name="active" type="checkbox" value="true"
               id="defaultCheck1">
    </div>

    <div class="mb-3">
        <label for="fulllname" class="form-label">Image</label>
        <input type="text" required name="image" class="form-control" id="fulllname">
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>

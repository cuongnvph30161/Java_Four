<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/18/2023
  Time: 5:51 PM
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
    <title>Update</title>
</head>
<body class="container" style="width: 500px">
<h1 style="text-align: center">Update Detail</h1>

<form action="update" method="post">
    <input type="hidden" name="id" value="${movie.id}">
    <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">Title</label>
        <input type="text" value="${movie.title}" name="title" required class="form-control" id="exampleInputPassword1">
    </div>
    <div class="mb-3">
        <label for="email" class="form-label">Description</label>
        <textarea name="description" required class="form-control" id="email"> ${movie.description}</textarea>
    </div>

    <div class="mb-3">
        <label class="form-label">Active:</label>
        <input class="form-check-input"  ${movie.active?"checked":""}  name="active" type="checkbox" value="true"
               id="defaultCheck1">
    </div>
    <div class="mb-3">
        <label for="fulllname" class="form-label">Image</label>
        <input type="text" required name="image" value="${movie.image}" class="form-control" id="fulllname">
    </div>
    <button formaction="update" type="submit" class="btn btn-primary">Save</button>
</form>
</body>
</html>

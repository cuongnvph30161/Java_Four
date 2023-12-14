<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/18/2023
  Time: 10:49 AM
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
    <title>Title</title>
</head>
<body>
<h1 style="text-align: center;">Quản lý Video </h1>
<table class="table" style="margin-top: 50px">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Title</th>
        <th scope="col">Description</th>
        <th scope="col">Active</th>
        <th scope="col">Image</th>
        <th scope="col">Function</th>


    </tr>
    </thead>
    <c:forEach items="${listVideo}" var="video">
        <tbody>
        <tr>
            <th scope="row">${video.id}</th>
            <td>${video.title}</td>
            <td>${video.description}</td>


            <td>
                <c:if test="${video.active}">Yes</c:if>
                <c:if test="${!video.active}">No</c:if>
            </td>

            <td width="100" >
                <img style="width: 50px;height: 50px" src="https://img.youtube.com/vi/${video.poster}/0.jpg
" alt="Movie Image">
            </td>

            <td>
                <a href="view-updateVideo?id=${video.id}">
                    <button type="button" class="btn btn-primary">Update</button>
                </a>

                <a href="deleteVideo?id=${video.id}"  onclick="return confirm('Do you want to delete this movie?');">
                    <button type="button" class="btn btn-warning">Delete</button>
                </a>

            </td>

        </tr>
        </tbody>
    </c:forEach>
</table>

<a href="view-addVideo"><button type="button" class="btn btn-success">Add Video</button></a>

</body>

</html>

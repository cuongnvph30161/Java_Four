
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Hiển thị danh sách</title>
</head>
<body>
<table class="table">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">PassWord</th>
        <th scope="col">Fullname</th>
        <th scope="col">Email</th>
        <th scope="col">Photo</th>
        <th scope="col">Activated</th>
        <th scope="col">Admin</th>
        <th scope="col">Functions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="u">
        <tr>
            <td>${u.id}</td>
            <td>${u.password}</td>
            <td>${u.fullname}</td>
            <td>${u.email}</td>
            <td width="100"><img style="width: 50px;height: 50px" src="${u.photo}"></td>

            <td>${u.activated==1 ?"Đã kích hoạt":"Chưa kích hoạt"}</td>
            <td>${u.admin==1 ?"Admin":"User"}</td>
            <td>

                <a href="view-update-user?id=${u.id}">
                    <button  type="button" class="btn btn-primary">Update</button>
                </a>

                <a href="delete-user?id=${u.id}">
                    <button type="button" class="btn btn-warning">Delete</button>
                </a>

            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="view-add-user">
    <button type="button" class="btn btn-danger">Add User</button>
</a>
</body>
</html>

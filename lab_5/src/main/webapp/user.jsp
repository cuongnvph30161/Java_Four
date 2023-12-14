<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="bootstrap.jsp"></jsp:include>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table class="table">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">PassWord</th>
        <th scope="col">Fullname</th>
        <th scope="col">Email</th>
        <th scope="col">Admin</th>
        <th scope="col">Funtions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list}" var="u">
        <tr>
            <td>${u.id}</td>
            <td>${u.password}</td>
            <td>${u.fullname}</td>
            <td>${u.email}</td>
            <td>${u.admin?"Admin":"User"}</td>
            <td>

                <a href="view-update?id=${u.id}">
                    <button  type="button" class="btn btn-primary">Update</button>
                </a>

                <a href="delete?id=${u.id}">
                    <button type="button" class="btn btn-warning">Delete</button>
                </a>

            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="view-create">
    <button type="button" class="btn btn-danger">Add User</button>
</a>
</body>
</html>

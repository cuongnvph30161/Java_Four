<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form method="post">
    <p>Id: <input value="${user.id}" name="id"></p>
    <p>Password: <input value="${user.password}" type="password" name="password"></p>
    <p>Fullname: <input value="${user.fullname}" name="fullname"></p>
    <p>Email: <input value="${user.email}" name="email"></p>
    <p>Admin: <input ${user.admin?"checked":""} type="checkbox" name="admin"></p>
    <button formaction="create">Create</button>
    <button formaction="update">Update</button>
    <button formaction="delete">Delete</button>
</form>
<table border="1">
    <c:forEach items="${list}" var="u">
        <tr>
            <td>${u.id}</td>
            <td>${u.password}</td>
            <td>${u.fullname}</td>
            <td>${u.email}</td>
            <td>${u.admin? "Admin" : "User"}</td>
            <td><a href="edit?id=${u.id}">Edit</a></td>
        </tr>
    </c:forEach>
</table>


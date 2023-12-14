<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form method="post">
    <input placeholder="Video Id?" value="${key}" name="videoId">
    <button type="submit">Search</button>
</form>



<table border="1">
    <tr>
        <th>Username</th>
        <th>Fullname</th>
        <th>Email</th>
        <th>Role</th>
    </tr>
    <c:forEach items="${list}" var="u">
        <tr>
            <td>${u.id}</td>
            <td>${u.fullname}</td>
            <td>${u.email}</td>
            <td>${u.admin !=0 ? "Admin":"User"}</td>
        </tr>
    </c:forEach>
</table>
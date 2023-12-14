<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form method="post">
    <input placeholder="Username?" value="${key}" name="userId">
    <button>Search</button>
</form>
<div>
    <p>Fullname:${user.fullname}</p>
    <p>Email:${user.email}</p>
</div>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Title</th>
        <th>Views</th>
        <th>Active</th>
    </tr>

    <c:forEach items="${list}" var="u">
    <tr>
        <td>${u.id}</td>
        <td>${u.title}</td>
        <td>${u.views}</td>
        <td>${u.active !=0? "Yes":"No"}</td>
    </tr>
    </c:forEach>
</table>
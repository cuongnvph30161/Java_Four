<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form>
    <input value="${param.keyword}" placeholder="Keyword" name="keyword">
    <button>Search</button>
</form>
<table border="1">
    <tr>
        <th>Id</th> <th>Title</th> <th>View</th> <th>Active</th>
    </tr>
    <c:forEach items="${list}" var="v">
        <tr>
            <td>${v.id}</td>
            <td>${v.title}</td>
            <td>${v.views}</td>
            <td>${v.active? "Yes": "No"}</td>
        </tr>
    </c:forEach>
</table>
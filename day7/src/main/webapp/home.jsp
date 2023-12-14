<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>Hello ${sessionScope.username}</div>

<c:if test="${sessionScope.username==null}">
    <a href="login">Login</a>
</c:if>

<c:if test="${sessionScope.username != null}">
    <a href="logout">Logout</a>
</c:if>
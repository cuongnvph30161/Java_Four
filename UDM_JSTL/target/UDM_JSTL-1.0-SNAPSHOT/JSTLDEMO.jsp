<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/8/2023
  Time: 11:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL Demo</title>
</head>
<body>
<%--<c:set var="name" value="Chaand"></c:set>--%>
<%--&lt;%&ndash;<c:out value="name"></c:out>&ndash;%&gt;--%>
<%--${name}--%>

<%--<jsp:useBean id="user" class="com.example.UDM_JSTL.User" scope="page"/>--%>
<%--<c:out value="${user.firstName}" />--%>

<%--<c:if test="${param.name =='chaand'}">--%>
<%--    Hello Chaand--%>
<%--</c:if>--%>
<%--Hello User--%>
<c:choose>
    <c:when test="${param.lang=='Java'}">
        Learning Java
    </c:when>
    <c:when test="${param.lang=='PHP'}">
        Learning PHP
    </c:when>
    <c:otherwise>
        Learning something good!
    </c:otherwise>
</c:choose>
</body>
</html>

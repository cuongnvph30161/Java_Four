<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/10/2023
  Time: 6:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Demo for loop</title>
</head>
<body>
<%-- <c:forEach var="i" begin="1" end="10" step="2">--%>
<%--     ${i}--%>
<%-- </c:forEach>--%>

<%
    String[] names = new String[3];
    names[0] = "Chaand";
    names[1] = "John";
    names[2] = "Nikita";

%>
<c:forEach items="<%=names%>" var="name">
    ${name}
    <br>
</c:forEach>

</body>
</html>

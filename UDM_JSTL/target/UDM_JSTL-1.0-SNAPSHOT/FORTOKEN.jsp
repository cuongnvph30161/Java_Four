<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/10/2023
  Time: 6:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>FORTOKEN</title>
</head>
<body>
<%
    String URL = "studenorsy.org";
%>
<c:forTokens items="<%=URL%>" delims="." var="temp">
    ${temp}
    <br>
</c:forTokens>
</body>
</html>

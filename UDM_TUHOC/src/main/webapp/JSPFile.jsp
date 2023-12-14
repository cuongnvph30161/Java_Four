<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/4/2023
  Time: 8:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- Sử dụng cho nội dung tĩnh--%>
<%@include file="file1.txt" %>
<%--Sử dụng cho nội dung động--%>
<jsp:include page="file2.txt"/>
<%----%>
<%@page import="java.util.Date" %>
<%= new Date()%>
</body>
</html>

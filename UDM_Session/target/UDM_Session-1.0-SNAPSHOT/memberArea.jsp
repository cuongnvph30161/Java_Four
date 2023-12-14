<%@ page import="jakarta.servlet.http.Cookie" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/4/2023
  Time: 11:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Member</title>
</head>
<body>
<h1>Member</h1>
<%

    String username = null, sessionID = null;
    if (request.getSession().getAttribute("username") == null) {
        response.sendRedirect(request.getContextPath() + "/SiteController?action=login");
    } else {
        username = request.getSession().getAttribute("username").toString();
        sessionID = request.getSession().getId();

    }

%>
<%--    Thông tin cookie  --%>
Username:<%=username%> <br>
Current session:<%=
sessionID
%>
<%--
đăng xuất người dùng bằng cookie
--%>
<form action="<%= request.getContextPath()%>/member" method="get">
    <input type="hidden" name="action" value="destroy">
    <input type="submit" value="logout">;
</form>

</body>
</html>

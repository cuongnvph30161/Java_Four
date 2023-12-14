<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<c:catch var="excepttiton">
    <%
        int x = 10 / 0;
    %>
</c:catch>
${excepttiton}
Testing.....
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String[] names = {"Chaand", "John", "Riya"};
%>
<c:set var="namesArray" value="<%=names%>"></c:set>
${fn:length(namesArray)}
</body>
</html>

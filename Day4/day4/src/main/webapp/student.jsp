<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Mark</th>
    </tr>
    <c:forEach items="${list}" var="st">
        <tr>
            <td>${st.name}</td>
            <td>${st.mark}</td>
        </tr>
    </c:forEach>
</table>
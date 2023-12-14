<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/25/2023
  Time: 10:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form>
    <input value="${key}" placeholder="Keyword?" name="keyword">
    <button>Search</button>
</form>

<table border="1">
<tr>
    <th>Id</th>
    <th>Title</th>
    <th>Views</th>
    <th>Active</th>
</tr>
  <c:forEach items="${list}" var="v">
      <tr>
          <td>${v.id}</td>
          <td>${v.title}</td>
          <td>${v.views}</td>
          <td>${v.active !=0 ? "Yes":"No"}</td>
      </tr>
  </c:forEach>
 </table>
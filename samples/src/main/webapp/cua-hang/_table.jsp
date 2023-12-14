<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table style="width: 100%" border="1">
    <thead>
    <tr>
        <th>#</th>
        <th>Mã</th>
        <th>Tên</th>
        <th>Địa chỉ</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${items}" var="ch" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${ch.ma}</td>
            <td>${ch.ten}</td>
            <td>${ch.diachi}, ${ch.thanhpho}, ${ch.quocgia}</td>
            <td>
                <a href="#">Detail</a>
                <a href="#">Update</a>
                <a href="#">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table border="1">
    <tr>
        <th>Mã</th>
        <th>Tên</th>
        <th>Địa chỉ tổng hợp</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${list}" var="ch">
        <tr>
            <td>${ch.ma}</td>
            <td>${ch.ten}</td>
            <td>${ch.diachi}-${ch.thanhpho}-${ch.quocgia}</td>
            <td>
                <a href="delete?id=${ch.id}">
                    <button type="button">Delete</button>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="view-create">
    <button type="button" class="btn btn-danger">Add Cửa hàng</button>
</a>
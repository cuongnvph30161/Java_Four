<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>${param.message}</div>
<table style="width: 100%" border="1">
    <thead>
    <tr>
        <th>#</th>
        <th>Năm BH</th>
        <th>Số lượng tồn</th>
        <th>Giá nhập</th>
        <th>Mô tả</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${items}" var="sp" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${sp.nambh}</td>
            <td>${sp.soluongton}</td>
            <td>${sp.gianhap}</td>
            <td>${sp.mota}</td>
            <td>
                <a href="detail?id=${sp.id}">Detail</a>
                <a href="view-update?id=${sp.id}">Update</a>
                <a href="delete?id=${sp.id}"
                    onclick="return confirm('Ban co muon xoa?')">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

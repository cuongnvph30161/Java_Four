<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table style="width: 100%" border="1">
    <thead>
    <tr>
        <th>#</th>
        <th>Tên</th>
        <th>SĐT</th>
        <th>Ngày sinh</th>
        <th>Địa chỉ</th>
        <th>Mật khẩu</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${items}" var="kh" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${kh.ho} ${kh.tendem} ${kh.ten}</td>
            <td>${kh.sdt}</td>
            <td>${kh.ngaysinh}</td>
            <td>${kh.diachi}</td>
            <td>${kh.matkhau}</td>
            <td>
                <a href="#">Detail</a>
                <a href="#">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
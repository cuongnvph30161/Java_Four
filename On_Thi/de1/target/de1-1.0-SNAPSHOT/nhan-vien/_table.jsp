<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table border="1">
    <tr>
        <td>#</td>
        <td>Mã</td>
        <td>Tên</td>
        <td>Giới tính</td>
        <td>Ngày sinh</td>
        <td>Địa chỉ</td>
        <td>Action</td>
    </tr>
    <c:forEach items="${list}" var="nv" varStatus="st">
        <tr>
            <td>${st.index+1}</td>
            <td>${nv.ma}</td>
            <td>${nv.ten}</td>
            <td>${nv.gioitinh? "Nam" : "Nữ"}</td>
            <td>${nv.ngaysinh}</td>
            <td>${nv.diachi}</td>
            <td>
                <a href="detail?id=${nv.id}">Detail</a>
                <a href="delete?id=${nv.id}"
                   onclick="return confirm('Ban co muon xoa?')"
                >Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form method="post">
    <p>Mã: <input type="text" name="ma" value="${nv.ma}"></p>     <p>${errorMa}</p>
    <p>Tên: <input type="text" name="ten" value="${nv.ten}"></p>   <p>${errorTen}</p>
    <p>Ngày sinh: <input type="text" name="ngaysinh" value="${nv.ngaysinh}"></p>  <p>${errorNgaySinh}</p>
    <p>Địa chỉ:
        <select name="diachi">
            <option ${nv.diachi == 'Hà nội' ? 'selected' : ''}>Hà nội</option>
            <option  ${nv.diachi == 'Tuyên quang' ? 'selected' : ''}>Tuyên quang</option>
            <option ${nv.diachi == 'Vũng tàu' ? 'selected' : ''}>Vũng tàu</option>
            <option  ${nv.diachi == 'Thuận hoá' ? 'selected' : ''}>Thuận hoá</option>
        </select>
    </p>

    <p>Giới tính:
        <input type="radio" name="gioitinh" ${nv.gioitinh ? "checked" : ""} value="true">Nam
        <input type="radio" name="gioitinh" ${!nv.gioitinh ? "checked" : ""} value="false">Nữ
    </p>

    <button formaction="add">Add</button>
</form>
<div>${message}</div>

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
            <td>${nv.gioitinh? "Nam":"Nữ"}</td>
            <td>${nv.ngaysinh}</td>
            <td>${nv.diachi}</td>
            <td>
                <a href="detail?id=${nv.id}">
                    <button>Detail</button>
                </a>
                <a href="delete?id=${nv.id}" onclick=" return confirm('Ban co  muon xoa') ">
                    <button>Delete</button>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
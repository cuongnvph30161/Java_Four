<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form method="post">
    <p>Mã:
        <input name="ma" type="text" value="${nv.ma}">  <i>${errorMa}</i>
    </p>
    <p>Tên:
        <input name="ten" type="text" value="${nv.ten}"> <i>${errorTen}</i>
    </p>
    <p>giới tính:
        <input name="gioitinh" type="radio" ${nv.gioitinh?'checked':''} value="true">Nam
        <input name="gioitinh" type="radio" ${!nv.gioitinh?'checked':''} value="false">Nữ
    </p>

    <p>Địa chỉ:
        <select name="diachi">
            <option ${nv.diachi=='Sóc sơn'?"selected":""}>Sóc Sơn</option>
            <option ${nv.diachi=='Cà Mau'?"selected":""}>Cà Mau</option>
        </select>
    </p>

    <p>Ngày sinh:
        <input name="ngaysinh" type="text" placeholder="yyyy-MM-dd" value="${nv.ngaysinh}"> <i>${errorNgaySinh}</i>
    </p>

    <button formaction="add">Add</button>
</form>
<div>${message}</div>

<table border="1">

    <tr>
        <th>#</th>
        <th>Mã</th>
        <th>Tên</th>
        <th>Giới tính</th>
        <th>Địa chỉ</th>
        <th>Ngày sinh</th>
        <th>Action</th>
    </tr>

    <c:forEach items="${list}" var="nv" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${nv.ma}</td>
            <td>${nv.ten}</td>
            <td>${nv.gioitinh? 'Nam':'Nữ'}</td>
            <td>${nv.diachi}</td>
            <td>${nv.ngaysinh}</td>
            <td>
                <a href="delete?id=${nv.id}" onclick="return confirm('Ban co muon xoa')">
                    <button>Remove</button>
                </a>

                <a href="detail?id=${nv.id}">
                    <button>Detail</button>
                </a>

                <a href="view-update?id=${nv.id}">
                    <button>Update</button>
                </a>

            </td>
        </tr>
    </c:forEach>

</table>
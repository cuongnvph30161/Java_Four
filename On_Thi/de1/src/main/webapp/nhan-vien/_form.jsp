<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form method="post" action="add">
    <p>Mã: <input name="ma" value="${nv.ma}"/></p>
    <p>Tên: <input name="ten" value="${nv.ten}"/></p>
    <p>Giới tính:
        <input type="radio" name="gioitinh" ${nv.gioitinh?"selected":""} value="true"> Nam
        <input type="radio" name="gioitinh" ${!nv.gioitinh?"selected":""} value="false"> Nữ
    </p>
    <p>Ngày sinh: <input name="ngaysinh" value="${nv.ngaysinh}" placeholder="yyyy-MM-dd"></p>
    <p>Địa chỉ: <input name="diachi" value="${nv.diachi}"></p>
    <button>Add</button>
</form>
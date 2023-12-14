<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form method="post" action="add">
    <p>Mã: <input name="ma"></p>
    <p>Tên: <input name="ten"></p>
    <p>Giới tính:
        <input type="radio" name="gioitinh" value="Nam"> Nam
        <input type="radio" name="gioitinh" value="Nữ"> Nữ
    </p>
    <p>Địa chỉ: <input name="diachi"></p>
    <button>Add</button>
</form>
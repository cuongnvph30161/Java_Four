
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<form method="post">
    <input name="id" type="hidden" value="${kh.id}">

    <p>Họ:
        <input name="ho" type="text" value="${kh.ho}">
    </p>
    <p>Tên Đệm:
        <input name="tendem" type="text" value="${kh.tendem}">
    </p>
    <p>Tên:
        <input name="ten" type="text" value="${kh.ten}">
    </p>
    <p>Ngày sinh:
        <input name="ngaysinh" type="text" placeholder="yyyy/MM/dd" value="${kh.ngaysinh}">
    </p>
    <p>Số điệnt thoại:
        <input name="sdt" type="text" value="${kh.sdt}">
    </p>
    <p>Địa chỉ:
        <select name="diachi">
            <option ${kh.diachi=='Sơn la'?'selected':''}>Sơn la</option>
            <option  ${kh.diachi=='Hoà bình'?'selected':''}>Hoà bình</option>
            <option ${kh.diachi=='Vũng tàu'?'selected':''}>Vũng tàu</option>
            <option ${kh.diachi=='Lũng Cú'?'selected':''}>Lũng Cú</option>

        </select>
    </p>

    <button formaction="update">Update</button>
</form>

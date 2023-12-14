
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form method="post">
    <input name="id" type="hidden" value="${nv.id}">

    <p>Mã:
        <input name="ma" type="text" value="${nv.ma}"> <i>${errorMa}</i>
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
    <button formaction="update">Update</button>

</form>
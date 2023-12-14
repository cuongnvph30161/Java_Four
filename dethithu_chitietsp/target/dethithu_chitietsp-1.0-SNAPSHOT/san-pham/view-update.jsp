<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form method="post">
    <input type="hidden" name="id" value="${sanpham.id}">
    <p>Năm bảo hành:
        <select name="nambh">
            <option ${sanpham.nambh==2000?'selected':''}>2000</option>
            <option  ${sanpham.nambh==2001?'selected':''}>2001</option>
            <option  ${sanpham.nambh==2002?'selected':''}>2002</option>
            <option  ${sanpham.nambh==2003?'selected':''}>2003</option>
            <option  ${sanpham.nambh==2004?'selected':''}>2004</option>
        </select>
    </p>
    <p>Số lượng tồn:
        <input type="text" name="soluongton" value="${sanpham.soluongton}">
    </p>
    <p>Giá nhập:
        <input type="text" name="gianhap" value="${sanpham.gianhap}">
    </p>
    <p>Mô tả:
        <input type="text" name="mota" value="${sanpham.mota}">
    </p>
    <button formaction="update">Update</button>
</form>

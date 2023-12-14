<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h1 style="margin-left: 500px">QUẢN LÝ CỬA HÀNG</h1>
<form method="post" style="margin-left: 500px">
    <p>
        Mã:
        <input type="text" name="ma"> <i>${errorMa}</i>
    </p>
    <p>
        Tên:
        <input type="text" name="ten"><i>${errorTen}</i>
    </p>
    <p>
        Thành phố:
        <select name="thanhpho">
            <option>Nam Định</option>
            <option>Hà Nội</option>
            <option>Vĩnh Phúc</option>
            <option>Yên Bái</option>
            <option>Lạng Sơn</option>

        </select>
    </p>
    <p>
        Quốc gia:
        <select name="quocgia">
            <option>Việt Nam</option>
            <option>Lào</option>
            <option>Trung Quốc</option>
        </select>
    </p>
    <p>
        Địa chỉ:
        <input type="text" name="diachi"><i>${errorDiaChi}</i>
    </p>
<button formaction="add" onclick="return confirm('Bạn có muốn add?')">Add</button>
</form>
<div>${message}</div>



<table border="1" style="margin-left: 500px">
    <tr>
        <th>#</th>
        <th>Mã</th>
        <th>Tên</th>
        <th>Địa chỉ tổng hợp</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${list}" var="ch" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${ch.ma}</td>
            <td>${ch.ten}</td>
            <td>${ch.diachi} ${ch.thanhpho} ${ch.quocgia}</td>
            <td>
                <a href="delete?id=${ch.id}" onclick="return confirm('Bạn có muốn xoá?')">
                    <button>Delete</button>
                </a>
            </td>

        </tr>
    </c:forEach>
</table>
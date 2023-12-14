<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/27/2023
  Time: 10:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<form method="post">
    <p>
        Mã:
        <input type="text" value="${maValue}" name="ma"> <i>${errorMa}</i>
    </p>

    <p>
        Tên:
        <input type="text" value="${tenValue}" name="ten"> <i>${errorTen}</i>
    </p>

    Thành phố <select name="thanhpho">
    <option value="Nam Định">Nam Định</option>
    <option value="Hà Nội">Hà Nội</option>
    <option value="Vĩnh Phúc">Vĩnh Phúc</option>
    <option value="Yên Bái">Yên Bái</option>
    <option value="Lạng Sơn">Lạng Sơn</option>
</select> <br>

    Quốc gia <select name="quocgia">
    <option value="Việt Nam">Việt Nam</option>
    <option value="Lào">Lào</option>
    <option value="Trung Quốc">Trung Quốc</option>

</select><br>
    <p>
        DiaChi:
        <input type="text" value="${diaChiValue}" name="diachi"> <i>${errorDiaChi}</i>
    </p>
    <button formaction="create" type="submit">Add</button>
</form>

<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/10/2023
  Time: 10:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <div class="mb-3">
        <label class="form-label">Tên:</label>
        <input required type="text" class="form-control" name="ten" aria-describedby="emailHelp">
    </div>

    <div class="mb-3">
        <label class="form-label">Giới tính:</label>
        <div class="form-check">
            <input required class="form-check-input" type="radio" name="gender" value="Nam">
            <label class="form-check-label">
                Nam
            </label>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="radio" name="gender" value="Nữ" checked>
            <label class="form-check-label">
                Nữ
            </label>
        </div>
    </div>


    <div class="mb-3">
        <label class="form-label">Số điện thoại:</label>
        <input required type="text" name="sodienthoai" class="form-control">
    </div>
    <div class="mb-3">
        <label class="form-label">Ngày sinh:</label>
        <input type="date" name="ngaysinh" class="form-control">
    </div>
    <div class="mb-3">
        <label class="form-label">Chuyên nghành:</label>
        <select class="form-select" name="chuyennghanh" aria-label="Default select example">
            <option selected>Vui lòng chọn</option>
            <option value="TKDH">TKDH</option>
            <option value="MTK">MTK</option>
            <option value="LOGICTIC">LOGICTIC</option>
        </select>
    </div>
    <button type="submit" class="btn btn-primsary">Lưu lại</button>
</form>
</body>
</html>

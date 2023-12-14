<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/16/2023
  Time: 8:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Thông tin nhân viên</h1>
<form method="post">
    Họ và tên: <input name="fullname"><br>
    Ngày sinh: <input name="birthday"><br>
    Quốc tịch:
    <select name="country">
        <option value="VN">Việt Nam</option>
        <option value="US">United States</option>
    </select><br>
    Giới tính:
    <input name="gender" type="radio" value="true">Nam
    <input name="gender" type="radio" value="false">Nữ<br>
    TT hôn nhân:
    <input name="married" type="checkbox">Đã có gia đình?<br>
    Sở thích:
    <input name="hobbies" type="checkbox" value="R">Đọc sách
    <input name="hobbies" type="checkbox" value="T">Du lịch
    <input name="hobbies" type="checkbox" value="M">Âm nhạc
    <input name="hobbies" type="checkbox" value="O">Khác<br>
    Ghi chú: <textarea name="notes" rows="3" cols="30"></textarea>
    <hr>
    <button>Thêm mới</button>
</form>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/8/2023
  Time: 6:53 AM
  To change this template use File | Settings | File Templates.
--%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"></script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dang ky</title>
</head>
<body class="container">

<div class="card" style="width: 40rem;">
    <div class="card-body">
        <h1 class="text-center"> Đăng Ký</h1>
        <form method="post">
            <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label">Tên đăng nhập:</label>
                <input type="text" class="form-control" name="dangnhap" id="exampleInputEmail1"
                       aria-describedby="emailHelp">
            </div>

            <div class="mb-3">
                <label for="exampleInputPassword1" class="form-label">Mật khẩu</label>
                <input type="password" name="matkhau" class="form-control" id="exampleInputPassword1">
            </div>

            <div class="mb-3 form-check">
                <label for="exampleInputPassword1" class="form-label">Giới tính</label>

                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gender" value="Nam" id="flexRadioDefault1">
                    <label class="form-check-label" for="flexRadioDefault1">
                        Nam
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="gender" value="Nữ" id="flexRadioDefault2"
                           checked>
                    <label class="form-check-label" for="flexRadioDefault2">
                        Nữ
                    </label>
                </div>
            </div>

            <div class="mb-3">
                <label for="exampleInputPassword1" class="form-label">Đã có gia đình:</label>
                <input class="form-check-input" type="checkbox" name="married" value="đã có gia đình"
                       id="defaultCheck1">
            </div>

            <div class="mb-3">
                <label for="exampleInputPassword1" class="form-label">Quốc tịch:</label>
                <select class="form-select" name="country" aria-label="Default select example">
                    <option selected>Vui lòng chọn</option>
                    <option value="VN">Việt Nam</option>
                    <option value="USA">USA</option>
                    <option value="ThaiLand">ThaiLand</option>
                </select>
            </div>

            <div class="mb-3">
                <label for="exampleInputPassword1" class="form-label">Ghi chú:</label>
                <textarea name="notes"></textarea>
            </div>
            <button type="submit" class="btn btn-primary" style="margin-left: 50%">Đăng ký</button>
        </form>
    </div>
</div>
</body>
</html>

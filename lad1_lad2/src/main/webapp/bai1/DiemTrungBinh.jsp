<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/10/2023
  Time: 10:25 AM
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
<div class="card" style="width: 30rem;">
    <form method="post">
        <div class="card-body">

            <div class="mb-3">
                <label class="form-label">Toán:</label>
                <input type="number" name="toan">
            </div>

            <div class="mb-3">
                <label class="form-label">Tiếng anh:</label>
                <input type="number" name="tienganh">
            </div>

            <div class="mb-3">
                <label class="form-label">Tin học:</label>
                <input type="number" name="tinhoc">
            </div>

        </div>
        <button>Tính điểm TB</button>
    </form>
</div>
</body>
</html>

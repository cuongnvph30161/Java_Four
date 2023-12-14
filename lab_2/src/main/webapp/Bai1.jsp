<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/8/2023
  Time: 5:34 AM
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
    <title>tam giac</title>
</head>
<body>

<h1>TAM GIÁC</h1>
<form method="post">
    <div class="mb-3">
        <input type="text"
               placeholder="Cạnh a?" name="a">
    </div>
    <div class="mb-3">
        <input type="text" placeholder="Cạnh b?" name="b">
    </div>
    <div class="mb-3">
        <input type="text" placeholder="Cạnh c?" name="c">
    </div>
    <button formaction="/lab_2_war_exploded/dien-tich" type="submit">Tính diện tích</button>
    <button formaction="/lab_2_war_exploded/chu-vi" type="submit">Tính chu vi</button>
    <h3>Kết quả: ${message}</h3>
</form>
</body>
</html>

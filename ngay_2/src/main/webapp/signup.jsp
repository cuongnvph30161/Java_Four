<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/6/2023
  Time: 10:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <p>Username: <input name="username"></p>
    <p> Gender:
        <input type="radio" name="gender" value="Nam">Male
        <input type="radio" name="gender" value="Nu">Female

    </p>
    <p>
        Marital status: <input type="checkbox" value="true" name="status">
    </p>
    <p>
        Country:
        <select name="country">
            <option>US</option>
            <option value="VN">VietNam</option>
        </select>
    </p>
    <button>Signup</button>
</form>
</body>
</html>

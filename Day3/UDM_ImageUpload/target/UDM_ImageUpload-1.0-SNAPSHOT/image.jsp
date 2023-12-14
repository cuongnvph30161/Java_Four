<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/17/2023
  Time: 6:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Image upload form</title>
</head>
<body>
<form action="ImageUpload" method="post" enctype="multipart/form-data">
    Select images <input type="file" name="file" multiple
>
    <input type="submit" value="upload">
</form>
</body>
</html>

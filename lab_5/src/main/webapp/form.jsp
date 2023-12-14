<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/20/2023
  Time: 10:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="bootstrap.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body class="container" style="width: 500px;">
<form  method="post">
<%--    <div class="mb-3">--%>
<%--        <label for="exampleInputEmail1" class="form-label">ID</label>--%>
<%--        <input type="text" name="id" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">--%>
<%--    </div>--%>

    <div class="mb-3">
        <label  class="form-label">Password</label>
        <input type="password" name="password" class="form-control">
    </div>

    <div class="mb-3">
        <label class="form-label">FullName</label>
        <input type="text" name="fullname" class="form-control" >
    </div>

    <div class="mb-3">
        <label class="form-label">Email</label>
        <input type="email" name="email" class="form-control" >
    </div>

    <div class="mb-3">
        <label class="form-label">Admin</label>
        <input class="form-check-input"  name="admin" type="checkbox" value="true"
               id="defaultCheck1">
    </div>

    <button formaction="create" type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>

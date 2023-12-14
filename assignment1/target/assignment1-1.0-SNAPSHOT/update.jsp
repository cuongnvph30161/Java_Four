<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form method="post">
    <input type="hidden" name="id" value="${user.id}">
    <p>Full Name:<input name="fullname" value="${user.fullname}"></p>
    <p>Admin: <input name="admin" type="checkbox" value="true"></p>
    <button>Update</button>
</form>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Add</h1>
<form method="post">
    <p>Id: <input type="text" name="id"></p>
    <p>Password: <input type="text" name="password"></p>
    <p>Fulname: <input type="text" name="fullname"></p>
    <p>Email: <input type="email" name=email></p>
    <p>photo: <input type="text" name="photo"></p>
    <p>Actived: <input type="text" name="actived"></p>
    <p>Admin: <input type="text" name="admin"></p>
    <button formaction="add-user"type="submit">Add</button>
</form>

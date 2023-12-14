<table border="1">
    <tr>
        <th>Id</th>
        <th>Password</th>
        <th>Fullname</th>
        <th>Role</th>
        <th></th>
    </tr>
    <c:forEach items="${list}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.password}</td>
            <td>${user.fullname}</td>
            <td>${user.admin? "Admin" : "User"}</td>
            <td>
                <a href="delete-user?id=${user.id}">Delete</a>
                <a href="update-user?id=${user.id}">Update</a>
            </td>
        </tr>
    </c:forEach>
</table>
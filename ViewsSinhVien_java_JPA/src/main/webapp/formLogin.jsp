
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
            rel="stylesheet"
    />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">
    <div class="formLogin">
        <form action="/LoginServlet" method="post">
            <label class="fw-bold">Name</label>
            <input type="text" class="form-control" name="name"> <br>
            <label class="fw-bold">Password</label>
            <input type="text" class="form-control" name="password"> <br>

            <button  class="btn btn-success text-center mt-3" type="submit">Đăng nhập</button>
        </form>
    </div>

</div>
</body>

<script>

</script>
</html>

<style>
    .formLogin{


        background-color: antiquewhite;
        border: 1px;
    }
</style>


</script>

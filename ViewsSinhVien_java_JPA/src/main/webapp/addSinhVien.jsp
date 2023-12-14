<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <div class="card">
        <header class="bg-primary text-white">
            <h4> Add new Students</h4>
        </header>

        <body>
        <form class="p-4" action="/sinhVien/add" method="post">
            <label class="fw-bold">Name</label>
            <input class="form-control" type="text" name="ten" id=""><br>
            <label class="fw-bold">Gennder</label>
            <input type="radio" name="gioiTinh" value="Male"> Nam
            <input type="radio" name="gioiTinh" value="Female"> Nu
            <br><br>
            <label class="fw-bold">Class</label>
            <select class="form-select" name="lop">
                <c:forEach items="${listLopHoc}" var="i">

                    <option value="${i.id}">${i.tenLop}</option>


                </c:forEach>
            </select>
            <label class="fw-bold">Location</label>
            <input class="form-control" type="text" name="diaChi"><br>

            <label class="fw-bold">height</label>
            <input class="form-control" type="text" name="chieuCao"><br>

            <label class="fw-bold">weith</label>
            <input class="form-control" type="text" name="canNang"><br>

            <div class="text-center mt-3">
                <button type="submit" class="btn btn-success">addNew</button>
            </div>
        </form>
        </body>
    </div>

</div>
</body>
</html>

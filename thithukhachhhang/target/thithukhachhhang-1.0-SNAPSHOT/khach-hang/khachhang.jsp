<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<form method="post">
<%--    <input name="id" type="hidden" value="${kh.id}">--%>
    <p>Mã:
        <input name="ma" type="text" value="${kh.ma}">   <i>${errorMa}</i>
    </p>
    <p>Họ:
        <input name="ho" type="text" value="${kh.ho}">   <i>${errorHo}</i>
    </p>

    <p>Tên Đệm:
        <input name="tendem" type="text" value="${kh.tendem}">   <i>${errorTenDem}</i>
    </p>
    <p>Tên:
        <input name="ten" type="text" value="${kh.ten}">   <i>${errorTen}</i>
    </p>
    <p>Ngày sinh:
        <input name="ngaysinh" type="text" placeholder="yyyy/MM/dd" value="${kh.ngaysinh}">    <i>${errorNgaySinh}</i>
    </p>
    <p>Số điệnt thoại:
        <input name="sdt" type="text" value="${kh.sdt}">      <i>${errorSDT}</i>
    </p>

    <p>Địa chỉ:
        <select name="diachi">
            <option ${kh.diachi=='Sơn la'?'selected':''}>Sơn la</option>
            <option  ${kh.diachi=='Hoà bình'?'selected':''}>Hoà bình</option>
            <option ${kh.diachi=='Vũng tàu'?'selected':''}>Vũng tàu</option>
            <option ${kh.diachi=='Lũng Cú'?'selected':''}>Lũng Cú</option>
        </select>
    </p>

<button formaction="add">Add</button>
</form>
<i>${message}</i>

<table border="1">
    <tr>
        <th>STT</th>
        <th>Mã</th>
        <th>Họ và tên</th>
        <th>Ngày sinh</th>
        <th>Số điện thoại</th>
        <th>Địa chỉ</th>
        <th>Action</th>

    </tr>

    <c:forEach items="${list}" var="kh" varStatus="loop">
        <tr>

            <td>${loop.count}</td>
            <td>${kh.ma}</td>
            <td>${kh.ho} ${kh.tendem} ${kh.ten}</td>
            <td>${kh.ngaysinh}</td>
            <td>${kh.sdt}</td>
            <td>${kh.diachi}</td>
            <td>
                <a href="detail?id=${kh.id}">
                    <button>detail</button>
                </a>
                <a href="view-update?id=${kh.id}">
                    <button>update</button>
                </a>
                <a href="delete?id=${kh.id}">
                    <button>remove</button>
                </a>


            </td>
        </tr>
    </c:forEach>

</table>
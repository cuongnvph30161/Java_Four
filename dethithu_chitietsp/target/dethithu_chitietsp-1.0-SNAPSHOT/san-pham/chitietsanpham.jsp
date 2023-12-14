<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<form method="post">
    <p>Năm bảo hành:
        <select name="nambh">
            <option ${sanpham.nambh==2000?'selected':''}>2000</option>
            <option  ${sanpham.nambh==2001?'selected':''}>2001</option>
            <option  ${sanpham.nambh==2002?'selected':''}>2002</option>
            <option  ${sanpham.nambh==2003?'selected':''}>2003</option>
            <option  ${sanpham.nambh==2004?'selected':''}>2004</option>
        </select>
    </p>
    <p>Số lượng tồn:
        <input type="text" name="soluongton" value="${sanpham.soluongton}"> <i>${errorSoLuongTon}</i>
    </p>
    <p>Giá nhập:
        <input type="text" name="gianhap" value="${sanpham.gianhap}"><i>${errorGiaNhap}</i>
    </p>
    <p>Mô tả:
        <input type="text" name="mota" value="${sanpham.mota}"><i>${errorMota}</i>
    </p>
    <button formaction="add">Add</button>
</form>

<p>${message}</p>

<table border="1">
    <tr>
        <th>STT</th>
        <th>Năm bảo hành</th>
        <th>Số lượng tồn</th>
        <th>Giá nhập</th>
        <th>Mô tả</th>
        <th>Action</th>
    </tr>

    <c:forEach items="${list}" var="sp" varStatus="st">
        <tr>
            <td>${st.index+1}</td>
            <td>${sp.nambh}</td>
            <td>${sp.soluongton}</td>
            <td>${sp.gianhap}</td>
            <td>${sp.mota}</td>
            <td>
                <a href="detail?id=${sp.id}">
                    <button>Detail</button>
                </a>
                <a href="delete?id=${sp.id}" onclick="return confirm('Ban co muon xoa?')">
                    <button>Remove</button>
                </a>
                <a href="view-update?id=${sp.id}">
                    <button>Update</button>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
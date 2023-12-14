<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form method="post" action="update">
    <input type="hidden" name="id" value="${sanpham.id}">
    <p>Năm bảo hàng:
        <select name="nambh">
            <c:forEach begin="2000" end="2020" var="nam">
                <option ${nam==sanpham.nambh?"selected":""}>${nam}</option>
            </c:forEach>
        </select>
    </p>
    <p>Số lượng tồn:
        <input type="number" min="0" name="soluongton"
               value="${sanpham.soluongton}">
    </p>
    <p>Giá nhập:
        <input type="number" min="0" name="gianhap"
               value="${sanpham.gianhap}">
    </p>
    <p>Mô tả: <input name="mota" value="${sanpham.mota}"></p>
    <button>Update</button>
</form>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table border="1">
    <tr>
        <th>STT</th>
        <th>NamBH</th>
        <th>Số lượng tồn</th>
        <th>Giá nhập</th>
        <th>Mô tả</th>
        <th></th>
    </tr>
    <c:forEach items="${list}" var="item" varStatus="st">
        <tr>
            <td>${st.index+1}</td>
            <td>${item.nambh}</td>
            <td>${item.soluongton}</td>
            <td>${item.gianhap}</td>
            <td>${item.mota}</td>
            <td>
                <a href="detail?id=${item.id}">Detail</a>
                <a href="delete?id=${item.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

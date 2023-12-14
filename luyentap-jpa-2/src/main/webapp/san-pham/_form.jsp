<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form method="post" action="add">
    <p>
        Nam BH:
        <select name="nambh">
            <option>----</option>
            <option ${sp.nambh==2020?"selected":""}>2020</option>
            <option ${sp.nambh==2021?"selected":""}>2021</option>
            <option ${sp.nambh==2022?"selected":""}>2022</option>
        </select>
    </p>
    <p>Số lượng tồn :
        <input name="soluongton" value="${sp.soluongton}"/></p>
</form>

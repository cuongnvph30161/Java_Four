<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form method="post" action="add">
    <p>Mã: <input name="ma"></p>
    <p>Tên: <input name="ten"></p>
    <p>Địa chỉ: <input name="diachi"></p>
    <p>Thành phố:
        <select name="thanhpho">
            <option value="">----</option>
            <option>Hà Nội</option>
            <option>Tp.HCM</option>
        </select>
    </p>
    <p>Quốc gia:
        <select name="quocgia">
            <option value="">----</option>
            <option>ViệtNam</option>
            <option>Lào</option>
            <option>Campuchia</option>
        </select>
    </p>
    <button>Add</button>
</form>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../layout/header.jsp" %>
<!--static -->
<jsp:include page="../layout/menu.jsp"> <!--dynamic -->
    <jsp:param name="currentPage" value="about"/>
</jsp:include>
<main>
    <h1>Giới thiệu</h1>
</main>
<%@include file="../layout/footer.jsp" %>

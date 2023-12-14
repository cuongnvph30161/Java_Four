<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/11/2023
  Time: 4:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
View website in:
<a href="?locale=en_US">English(US)</a>
<a href="?locale=en_AR">Argentina</a>
<a href="?locale=ru_RU">Russia</a>
<a href="?locale=hi_IN">India</a>
<br/>
<hr/>
<fmt:setLocale value="${param.locale}"/>
<fmt:bundle basename="i18n/website">
<p>
    <fmt:message key="label.helllo">John</fmt:message>
<p>
        <fmt:message key="label.welcome"/>
<p>
        <fmt:message key="label.message"/>
<p>
        <fmt:message key="label.thanks"/>
    </fmt:bundle>
    <br/>
    Locale: ${param.locale}
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/11/2023
  Time: 10:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<br/> ${fn:toUpperCase("cuong.Org")}
<br/> ${fn:toLowerCase("cuong.Org")}
<br/> ${fn:indexOf("cuong.Org","u")}
<br/> ${fn:replace("cuong","nguyen","van")}
<br/> ${fn:substring("cuong.org",2 ,5 )}
<br/> ${fn:substringBefore("hihiHappy","Happy")}
<br/> ${fn:substringAfter("thucuoi","thu" )}


</body>
</html>

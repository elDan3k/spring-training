<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title><s:message code="title"/></title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <link href="assets/css/style.css">
</head>
<body>
<div class="container">
    <%@ include file="menu.jsp" %>
    <div class="content">
        <s:message code="success"/>
    </div>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>

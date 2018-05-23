<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
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
        <s:message code="newAccountConfirmation"/> ${account.number}
    </div>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <h1><s:message code="operation"/> ${param.operationName}</h1>
        <sf:form modelAttribute="disposition" method="post">
            <div class="form-group">
                <label for="accountNumber"><s:message code="accountNumber"/></label>
                <sf:input id="accountNumber" class="form-control" path="accountNumber"/>
                <sf:errors path="accountNumber"/>
            </div>
            <div class="form-group">
                <label for="funds"><s:message code="funds"/></label>
                <sf:input id="funds" class="form-control" path="funds"/>
                <sf:errors path="funds"/>
            </div>
            <button type="submit" class="btn btn-primary float-right"><s:message code="submit"/></button>
        </sf:form>

    </div>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>

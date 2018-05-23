<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <h1><s:message code="accounts"/></h1>
        <c:if test="${accountsPage.totalPages > 0}">
            <table class="table">
                <thead>
                <tr>
                    <th><s:message code="accountNumber"/></th>
                    <th><s:message code="funds"/></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="account" items="${accountsPage.data}">
                    <tr>
                        <td>${account.number}</td>
                        <td><f:formatNumber type="currency" value="${account.balance / 100}"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <c:if test="${accountsPage.pageNumber > 0}">
                <a href="accounts.html?pageNumber=${accountsPage.pageNumber - 1}"><s:message code="previousPage"/></a>
            </c:if>
            <c:if test="${accountsPage.pageNumber + 1 < accountsPage.totalPages}">
                <a href="accounts.html?pageNumber=${accountsPage.pageNumber + 1}" class="float-right"><s:message code="nextPage"/></a>
            </c:if>
            <div class="text-center">
                    ${accountsPage.pageNumber + 1} / ${accountsPage.totalPages}
            </div>
        </c:if>
    </div>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>

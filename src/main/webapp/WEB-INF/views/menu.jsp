<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<ul class="nav nav-pills">
    <li class="nav-item">
        <a class="nav-link" href="create-account.html"><s:message code="createAccountLink"/></a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="disposition.html?operationName=deposit"><s:message code="depositLink"/></a>
    </li>
    <sec:authorize access="hasRole('Test')">
        <li class="nav-item">
            <a class="nav-link" href="disposition.html?operationName=withdraw"><s:message code="withdrawLink"/></a>
        </li>
    </sec:authorize>
    <li class="nav-item">
        <a class="nav-link" href="accounts.html"><s:message code="accountsLink"/></a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="logout.html">
            <s:message code="logoutLink"/>
            <sec:authentication property="principal.username"/>
        </a>
    </li>
</ul>
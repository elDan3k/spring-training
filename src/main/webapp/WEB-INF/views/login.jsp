<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Bank</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <link href="assets/css/style.css">
    <meta charset="UTF-8">
</head>
<body>
<div class="container">
    <h1>Login</h1>
    <form method="post">
        <div class="form-group">
            <label for="login">Username:</label>
            <input id="login" class="form-control" name="username"/>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input id="password" type="password" class="form-control" name="password"/>
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <button type="submit" class="btn btn-primary float-right">Submit</button>
    </form>
    <c:if test="${param.error != null}">Invalid username or password</c:if>
</div>
<%@ include file="footer.jsp" %>
</body>
</html>

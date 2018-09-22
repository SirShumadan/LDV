<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<%--login form--%>
<div>
    <form action="${pageContext.request.contextPath}/j_spring_security_check" method="post">
        <h2>Please sign in.</h2>
        <input type="text" placeholder="Email address" name="username">
        <input type="password" placeholder="Password" name="password">
        <button type="submit">Sign in!</button>
    </form>
</div>
</body>
</html>
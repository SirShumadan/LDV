<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<jsp:include page="parts/menu.jsp"/>

<%--login form--%>
<h1>Login</h1>
<c:if test="${param.error == 'true'}">
    <div style="color: red">
        Login Failed!
        Reason: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
    </div>
</c:if>
<div>
    <form action="${pageContext.request.contextPath}/j_spring_security_check" method="post">
        <h2>Enter your email and password: </h2>
        <input type="text" placeholder="Email address" name="username">
        <input type="password" placeholder="Password" name="password">
        <button type="submit">Sign in!</button>
    </form>
</div>
</body>
</html>
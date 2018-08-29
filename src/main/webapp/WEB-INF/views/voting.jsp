<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Voting</title>
</head>
<body>
<h3>Voting Page.</h3>
<c:forEach var="restaurant" items="${restaurants}">
    <tr>${restaurant.name}</tr>
    <br/>
</c:forEach>
</body>
</html>

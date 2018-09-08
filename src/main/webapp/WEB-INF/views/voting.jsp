<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Voting</title>
</head>
<body>
<h3>Voting Page</h3>
<c:forEach var="restaurant" items="${restaurants}">
    <tr>
        <td>${restaurant.name}</td>
        <td>
            <form method="post" action="voting/vote">
                <input type="hidden" name="restaurantId" value="${restaurant.id}">
                <input type="submit" value="vote!">
            </form>
        </td>
    </tr>
    <br/>
</c:forEach>
</body>
</html>

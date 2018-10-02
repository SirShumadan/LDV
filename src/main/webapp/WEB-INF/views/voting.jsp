<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Voting</title>
</head>
<body>

<jsp:include page="parts/menu.jsp"/>

<h3>Voting Page</h3>
<table>
    <c:forEach var="restaurant" items="${restaurants}">

        <tr><h3>${restaurant.name}</h3></tr>
        <c:forEach var="dish" items="${restaurant.dishes}">
            <li><b>${dish.name}</b> price: ${dish.price}</li>
        </c:forEach>
        <tr>
            <form method="post" action="voting/vote">
                <input type="hidden" name="restaurantId" value="${restaurant.id}">
                <input type="submit" value="vote!">
            </form>
        </tr>
    </c:forEach>
</table>
</body>
</html>

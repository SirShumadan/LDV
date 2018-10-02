<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../parts/menu.jsp"/>
<br/>
<a href="${pageContext.request.contextPath}/restaurant/new">Add new Restaurant</a>
<br/>
    <c:forEach var="restaurant" items="${restaurants}">
        <table>
            <tr><h3>${restaurant.name}</h3></tr>
            <c:forEach var="dish" items="${restaurant.dishes}">
                <li><b>${dish.name}</b> price: ${dish.price}</li>
            </c:forEach>
            <tr><a href="${pageContext.request.contextPath}/restaurant/${restaurant.id}">EDIT</a></tr>
        </table>
    </c:forEach>
</body>
</html>

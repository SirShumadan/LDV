<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Restaurant</title>
</head>
<body>
<jsp:include page="../parts/menu.jsp"/>
<table>
    <tr>
        <td><h3>${restaurant.name}</h3></td>
    </tr>
    <c:forEach var="dish" items="${restaurant.dishes}">
        <tr>
            <td>
                <li><b>${dish.name}</b> price: ${dish.price}</li>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/restaurant/${restaurant.id}/dish/edit/${dish.id}">EDIT</a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/restaurant/${restaurant.id}/dish/delete/${dish.id}">DELETE</a>
            </td>
        </tr>
    </c:forEach>
</table>
<div>
    <br/>
    <a href="${pageContext.request.contextPath}/restaurant/${restaurant.id}/dish/new">NEW DISH</a>
</div>
<div>
    <br/>
    <a href="${pageContext.request.contextPath}/restaurant/delete/${restaurant.id}"><b>DELETE RESTAURANT</b></a>
</div>
</body>
</html>

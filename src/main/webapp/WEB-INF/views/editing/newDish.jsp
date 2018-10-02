<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Dish</title>
</head>
<body>
<jsp:include page="../parts/menu.jsp"/>
<form action="${pageContext.request.contextPath}/restaurant/${restaurantId}/dish/save" method="post">
    <input type="text" name="name" placeholder="Dish name" />
    <input type="number" step="0.01" name="price" placeholder="Dish price"/>
    <button type="submit">CREATE</button>
</form>
</body>
</html>

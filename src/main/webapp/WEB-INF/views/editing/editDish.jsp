<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit dish</title>
</head>
<body>
<jsp:include page="../parts/menu.jsp"/>
<form action="${pageContext.request.contextPath}/restaurant/${restaurantId}/dish/save" method="post">
    <input type="hidden" name="id" value="${dish.id}"/><br/>
    New dish name: <input type="text" name="name" value="${dish.name}"/> <br/>
    New dish price: <input type="number" step="0.01" name="price" value="${dish.price}"/><br/>
    <button type="submit">SAVE</button>
</form>
</body>
</html>

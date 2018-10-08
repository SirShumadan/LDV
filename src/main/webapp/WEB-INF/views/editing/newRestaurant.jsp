<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../parts/menu.jsp"/>
<form action="${pageContext.request.contextPath}/restaurant" method="post">
    <table width="50%">
        <tr>
            <div style="margin-bottom: 10px">
                <b>Restaurant name: </b>
                <input type="text" name="restaurantName"/><br/>
            </div>
        </tr>
        <tr>
            Dish #1 name: <input type="text" name="dishName0"/>
            price: <input type="number" step="0.01" name="dishPrice0"/>
        </tr>
        <tr>
            <td>
                Dish #2 name: <input type="text" name="dishName1"/>
                price: <input type="number" step="0.01" name="dishPrice1"/>
            </td>
        </tr>
    </table>
    <button type="submit">CREATE</button>
</form>
</body>
</html>

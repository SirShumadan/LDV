<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <a href="${pageContext.request.contextPath}/">Home</a>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <a href="${pageContext.request.contextPath}/logout">Logout</a>
    </c:if>
    <c:if test="${pageContext.request.userPrincipal.name == null}">
        <a href="${pageContext.request.contextPath}/login">Login</a>
    </c:if>
</div>
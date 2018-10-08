<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div style="height: 40px">
    <a href="${pageContext.request.contextPath}/">Home</a>
    <a href="${pageContext.request.contextPath}/voting">Voting</a>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <a href="${pageContext.request.contextPath}/logout">Logout</a>
    </c:if>
    <c:if test="${pageContext.request.userPrincipal.name == null}">
        <a href="${pageContext.request.contextPath}/login">Login</a>
    </c:if>
    <sec:authorize access="hasRole('ADMIN')">
        <a href="${pageContext.request.contextPath}/admin">Admin Page</a>
    </sec:authorize>
</div>
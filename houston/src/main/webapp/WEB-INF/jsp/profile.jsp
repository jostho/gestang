<%@ include file="/WEB-INF/jsp/include.jsp" %>

<html>
<title>Houston :: profile</title>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
<p>The time here is <c:out value="${now}"/> You are looking at your profile </p>

principal.username : <sec:authentication property="principal.username"/> <br/>
Principal : <c:out value="${pageContext.request.userPrincipal}" />

<%@ include file="/WEB-INF/jsp/footer.jsp" %>
<sec:authorize ifAnyGranted="ROLE_ADMIN">
	<a href="<c:url value="/admin/users.do"/>">manage users</a>
</sec:authorize>
</body>
</html>

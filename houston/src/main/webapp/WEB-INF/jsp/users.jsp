<%@ include file="/WEB-INF/jsp/include.jsp" %>

<html>
<title>Houston :: admin</title>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
<p>You are looking at users page.</p>
<table border="1">
<c:forEach var="user" items="${usersList}">
 <tr><td><c:out value="${user.id}"/></td>
 <td><c:out value="${user.name}"/></td>
 <td><c:out value="${user.email}"/></td></tr>
 </c:forEach>
</table>
<%@ include file="/WEB-INF/jsp/footer.jsp" %>
<a href="<c:url value="/profile.do"/>">profile</a>
</body>
</html>

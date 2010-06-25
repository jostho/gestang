<%@ include file="/WEB-INF/jsp/include.jsp" %>

<html>
<title>Topper :: success</title>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
<p> <c:out value="${employee}"/> was updated successfully.</p>

Check out the below links <br/>
<a href="<c:url value="/search.html"/>">search employees</a>

<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>
</html>
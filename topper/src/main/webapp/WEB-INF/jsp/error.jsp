<%@ include file="/WEB-INF/jsp/include.jsp" %>

<html>
<title>Topper :: error</title>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
<p>You are looking at <i>error</i> page.</p>

<p>Exception is: ${exception}</p>

Check out the below links <br/>
<a href="<c:url value="/search.html"/>">search employees</a>
 |  
<a href="<c:url value="/edit.html"/>">add/update employee</a>

<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>
</html>

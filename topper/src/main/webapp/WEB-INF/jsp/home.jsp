<%@ include file="/WEB-INF/jsp/include.jsp" %>

<html>
<title>Topper :: home</title>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp" />

Check out the below links <br/>
<a href="<c:url value="/search.html"/>">search employees</a>
 |  
<a href="<c:url value="/edit.html"/>">add/update employee</a>

<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>
</html>

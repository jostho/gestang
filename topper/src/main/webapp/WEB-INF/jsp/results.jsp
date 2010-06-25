<%@ include file="/WEB-INF/jsp/include.jsp" %>

<html>
<title>Topper :: search</title>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
<p>You are looking at employees page.</p>

<table border="1">
<c:forEach var="employee" items="${employees}">
 <tr>
  <td> <c:out value="${employee.id}"/></a> </td>
  <td> <c:out value="${employee.firstName} ${employee.lastName}"/> </td>
  <td> <c:out value="${employee.email}"/> </td>
  <td> <c:out value="${employee.designation}"/> </td>
  <td> <fmt:formatDate pattern="yyyy-MM-dd" value="${employee.dateOfJoining}"/> </td>
  
  <td> <sub><a href="<c:url value='/edit.html?employeeId=${employee.id}'/>">edit</a></sub> </td>  
  <td> <sub><a href="<c:url value='/delete.html?employeeId=${employee.id}'/>">delete</a></sub> </td>  
 </tr>
 </c:forEach>
</table>

Check out the below links <br/>
<a href="<c:url value='/edit.html'/>">add employee</a>

<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>
</html>

<%@ include file="/WEB-INF/jsp/include.jsp" %>

<html>
<title>Topper :: edit</title>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp" />
<p>You are looking at add/update employee page.</p>

<form action="edit.html" method="POST">
<table border="1">
 <tr>
  <td>Employee id </td> 
  <td> <input type="input" name="id" readonly="readonly" value="<c:out value='${employee.id}'/>"></td>
  <td> <i>auto-generated</i> </td> 
 </tr>
 <tr>
  <td>First name </td> 
  <td> <input type="input" name="firstName" value="<c:out value='${employee.firstName}'/>"></td>
  <td> </td> 
 </tr> 
 <tr>
  <td>Last name </td> 
  <td> <input type="input" name="lastName" value="<c:out value='${employee.lastName}'/>"></td>
  <td> </td>  
 </tr>
  <tr>
  <td>Email </td> 
  <td> <input type="input" name="email" value="<c:out value='${employee.email}'/>"></td>
  <td> <i>user@domain.com</i> </td>  
 </tr>  
  <tr>
  <td>Designation </td> 
  <td> <input type="input" name="designation" value="<c:out value='${employee.designation}'/>"></td>
  <td> </td>  
 </tr>  
  <tr>
  <td>Date of joining  </td> 
  <td> <input type="input" name="dateOfJoining" value="<fmt:formatDate pattern='yyyy-MM-dd' value='${employee.dateOfJoining}'/>"></td>
  <td> <i>yyyy-mm-dd</i> </td>   
 </tr>  
 <tr>
  <td>  </td> 
  <td> <input type="submit" name="save" value="save"></td>
 </tr>  
</table>
</form>

Check out the below links <br/>
<a href="<c:url value="/search.html"/>">search employees</a>
<jsp:include page="/WEB-INF/jsp/footer.jsp" />
</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>user home</title>
</head>
<body>
	<!-- write the html code to display hyperlinks for user functionalities -->
	

<jsp:include page="header.jsp"/>
<h4>User Dash Board</h4>
<div align="right"><a href="index.jsp">Logout</a></div>
<a href="application.jsp">Apply for Loan</a><br>
<a href="trackloan.jsp">Track Loan Application</a><br>
<a href="editloan.jsp">Edit Loan Application</a>
<br>
<br>
<span style="color:red;"> 
	<c:if test="${failMsg!=null}">${failMsg}</c:if>
</span>
<span style="color:green;"> 
	<c:if test="${sucsMsg!=null}">${sucsMsg}</c:if>
</span>
		
<jsp:include page="footer.jsp"/>

</body>
</html>
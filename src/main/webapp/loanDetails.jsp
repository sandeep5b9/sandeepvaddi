<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<div align=center>
<body>
		<h2>Loan Details</h2>
		<div align="left"><a href="userhome1.jsp">Back</a></div>
		<div align="right"><a href="index.jsp">Logout</a></div>
	<!-- write the code to display the loan status information 
	     received from usercontrollers' displaystatus method
	-->
	<span style="color:red;"> 
		<c:if test="${failMsg!=null}">${failMsg}</c:if>
	</span>
	<span style="color:green;"> 
		<c:if test="${sucsMsg!=null}">${sucsMsg}</c:if>
	</span>

</body>
</html>
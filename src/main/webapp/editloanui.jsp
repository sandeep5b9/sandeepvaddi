<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<div align=center>
<h2>Update Loan Amount</h2>
<hr/>
<hr/>
<form action="user?action=editLoanProcess" method="post">
	<div align="right"><a href="index.jsp">Logout</a></div>
	<div align="right"><a href="adminhome1.jsp">Admin Home</a></div>
	
	<div>
		<br/>
		<div><label for="Loan Application Number">Enter Application Number</label> </div>
		<br/>
		<div><input type="text" id="LoanApplicationNumber" name="LoanApplicationNumber" value="${loanId}" readonly> </div>
	</div>
			
	<div>
		<br/>
		<div><label for="Enter Amount">Amount</label> </div>
		<br/>
		<div><input type="text" id="EnterAmount" name="EnterAmount"> </div>
	</div>
	<div>
		<br/>
		<div><input type="submit" value="Submit"> </div>
	</div>
</form>			
<jsp:include page="footer.jsp"/>
</body>
</html>
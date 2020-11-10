<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<!-- write the code to read application number, and send it to admincontrollers
	     callemi method to calculate the emi and other details also provide links
	     to logout and admin home page
	-->

	<form action="admin?action=callemi" method="post">
		<div>
			<div align="right"><a href="index.jsp">Logout</a></div>
			<br/>
			<div align="right"><a href="adminhome1.jsp">Admin Home</a></div>
			
			<div>
				<br/>
				<div align="center">
				<div><label for="Loan Application Number">Enter Application Number</label> </div>
				<br/>
				<div><input type="text" id="LoanApplicationNumber" name="LoanApplicationNumber"> </div>
			</div>
			<div>
				<br/>
				<div align="center">
				<div><input type="submit" value="Submit"> </div>
			</div>
		</div>	
	</form>
	
</body>
</html>
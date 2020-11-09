<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Loan Application</title>
</head>
<body>
	<!-- read the application number to edit from user and send to 
	     user controller to edit info
	-->
	
	<div align=center>
		<h2>Edit Loan</h2>
		<hr/>
		<form action="user?action=editloan" method="post">
			<div>
				<br/>
				<div><label for="Loan Application Number">Enter Application Number</label> </div>
				<br/>
				<div><input type="text" id="LoanApplicationNumber" name="LoanApplicationNumber"> </div>
			</div>
			<div>
				<br/>
				<div><input type="submit" value="Submit"> </div>
			</div>
		</form>
	</div>
	

</body>
</html>
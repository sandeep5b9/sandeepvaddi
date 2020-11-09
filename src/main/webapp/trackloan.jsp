<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loan Tracking</title>
</head>
<body>
	<!-- write html code to read the application number and send to usercontrollers'
             displaystatus method for displaying the information
	-->
	
	<div align=center>
	<h2>Track Loan</h2>
	<hr/>
	<form action="user?action=displaystatus" method="post">
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
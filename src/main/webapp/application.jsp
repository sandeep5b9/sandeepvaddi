<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loan Application Form</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
</head>
<body onload="myFunction()">

<!--
	write the html code to accept laon info from user and send to placeloan servlet
	
-->
<div align=center>
		<h2>New Loan Application</h2>
		<form action="user?action=placeloan" method="post">
			<!-- <div>
				<div>
					<label for="Customer Id">Customer Id</label>
				</div>
				<div>
					<input type="number" id="CustomerId" name="CustomerId">
				</div>
			</div> -->
			<br />
			<div>
				<div>
					<label for="Loan Type">Loan Type</label>
				</div>
				<div>
					<select name="LoanType">
					  <option value="0">--Select One--</option>
					  <option value="Mortgage">Mortgage</option>
					</select>
				</div> 
			</div>
			<br /> 
			<div>
				<div>
					<label for="Loan Amount">Loan Amount</label>
				</div>
				<div>
					<input type="number" id="LoanAmount" name="LoanAmount">
				</div>
			</div>
			<br /> 
			<div>
				<div>
					<label for="Application Date">Application Date</label>
				</div>
				<div>
					<input type="date" name="doa" id="date">
				</div>
			</div>
			<br /> 
			<div>
				<div>
					<label for="Business Structure">Business Structure</label>
				</div>
				<div>
					<select name="Business Structure">
					  <option value="0">--Select One--</option>
					  <option value="Individual">Individual</option>
					  <option value="Organisation">Organisation</option>
					</select>
				</div> 
			</div>
			<br /> 
			<div>
				<div>
					<label for="Billing Indicator">Billing Indicator</label>
				</div>
				<div>
					<select name="Billing Indicator">
					  <option value="0">--Select One--</option>
					  <option value="Salaried">Salaried</option>
					  <option value="Not Salaried">Not Salaried</option>
					</select>
				</div> 
			</div>
			<br />
			<div>
				<div>
					<label for="Address">Address</label>
				</div>
				<div>
					<input type="text" id="Address" name="Address">
				</div> 
			</div>
			<br /> 
			<div>
				<div>
					<label for="Mobile">Mobile Number</label>
				</div>
				<div>
					<input type="number" id="Mobile" name="Mobile">
				</div> 
			</div>
			<br /> 
			<div>
				<div>
					<label for="Email Id">Email Id</label>
				</div>
				<div>
					<input type="text" id="EmailId" name="EmailId">
				</div> 
			</div>
			<br /> 
			<div>
				<div>
					<label for="term">Term</label>
				</div>
				<div>
					<input type="text" id="term" name="term">
				</div> 
			</div>
			<br /> 
			<div>
				<div>
					<input type="submit" value="Submit">
				</div>
			</div>
			<br /> 
		</form>
		<span style="color:red;"> 
			<c:if test="${failMsg!=null}">${failMsg}</c:if>
		</span>
		<span style="color:green;"> 
			<c:if test="${sucsMsg!=null}">${sucsMsg}</c:if>
		</span>
	</div>

</script>


</body>
</html>
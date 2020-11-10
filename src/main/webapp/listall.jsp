<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display All Loans</title>
</head>
<body>
	
<div align=center>
<h2>Loans List</h2>
<hr/>
<c:choose>
	<c:when test="${loans==null || loans.isEmpty() }">
		<p style="font: normal; font-size: 30px; color: red;">No loans found!!</p>
	</c:when>
	<c:otherwise>
		<div align="center">
			<div style="display: inline-block; border: thin solid black; padding: 10px;">
				<table border="2" cellspacing="2px" cellpadding="2px">
					<thead>
						<tr style="color: brown; font-weight: bold">
							<td>App no.</td>
							<td>Purpose</td>
							<td>Amount Request</td>
							<td>Date of Application</td>
							<td>Bstructure</td>
							<td>BIndicator</td>
							<td>Status</td>
							<td>Address</td>
							<td>Email</td>
							<td>Mobile</td>
							<td>Term</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${loans }" var="loan">
							<tr>
								<td>${loan.applno }</td>
								<td>${loan.purpose }</td>
								<td>${loan.amtrequest }</td>
								<td>${loan.doa }</td>
								<td>${loan.bstructure }</td>
								<td>${loan.bindicator }</td>
								<td>${loan.status }</td>
								<td>${loan.address }</td>
								<td>${loan.email }</td>
								<td>${loan.mobile }</td>
								<td>${loan.term }</td>
				
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</c:otherwise>
</c:choose>
<hr/>
<form action="user?action=editLoanProcess" method="post">
	<div align="right"><a href="index.jsp">Logout</a></div>
	<div align="right"><a href="adminhome1.jsp">Admin Home</a></div>
	
	
			
</form>			

</body>
</html>
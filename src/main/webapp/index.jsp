<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align=center>
		<h2>eLoan Login</h2>
		<form action="user?action=validate" method="post">
			<div>
				<div>
					<label for="loginid">Enter login Id</label>
				</div>
				<div>
					<input type="text" id="loginid" name="loginid">
				</div>
			</div>
			<div>
				<div>
					<label for="password">Enter password</label>
				</div>
				<div>
					<input type="password" id="password" name="password">
				</div>
			</div>
			<div>
				<div>
					<input type="submit" value="Login">
				</div>
			</div>
			<br /> 
			<span>New User? <a href="newuserui.jsp">Register Here</a></span>
		</form>
		<span style="color:red;"> 
			<c:if test="${failMsg!=null}">"${failMsg}"</c:if>
		</span>
		<span style="color:green;"> 
			<c:if test="${sucsMsg!=null}">"${sucsMsg}"</c:if>
		</span>
	</div>


</body>
</html>
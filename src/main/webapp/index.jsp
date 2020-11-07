<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align=center>
	<h2>eLoan Login</h2>
	<form action="validate" method="post">
		<div>
			<div><label for="loginid">Enter login Id</label> </div>
			<div><input type="text" id="loginid" name="loginid"> </div>
		</div>
		<div>
			<div><label for="password">Enter password</label> </div>
			<div><input type="text" id="password" name="password"> </div>
		</div>
		<div>
			<div><input type="submit" value="Login"> </div>
		</div>
		<br/>
		<a href="register.jsp"? s1=link>New User? register here</a>
	</form>
	</div>
	</div>

	<!-- write the html code to read user credentials and send it to validateservlet
	    to validate and user servlet's registernewuser method if create new user
	    account is selected
	-->
</body>
</html>
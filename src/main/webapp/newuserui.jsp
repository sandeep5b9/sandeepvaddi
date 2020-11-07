<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>eLoan New User</title>
</head>
<body>
<h1>New User Registration Page</h1>
<hr/>
<form action="user" method="post">
	<br/>
	<label>Enter login-Id</label>
	<br/>
	<input type="text" name="logid"/>
	<br/><br/>
	<label>Enter password</label>
	<br/>
	<input type="password" name="password"/>
	<br/><br/>
	<input type="submit" value="Login" />
	<input type="submit" value="Cancel" />
	<a action="user?action=registerUser"></a>

<body>
	<!-- read user name and password from user to create account
	     and send to usercontrollers registeruser method
	-->

</body>
</html>
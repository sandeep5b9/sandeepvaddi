<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register New User</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<hr/>
<div align=center>
	<h2>Register New User</h2>
	<form action="user?action=registernewuser" method="post">
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
	</form>
	<span>Existing User? <a href="index.jsp">Login</a></span>
	<span style="color:red;"> 
		<c:if test="${failMsg!=null}">${failMsg}</c:if>
	</span>
</div>
<hr/>
<jsp:include page="footer.jsp"/>
</body>
</html>
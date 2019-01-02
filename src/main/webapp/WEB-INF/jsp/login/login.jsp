<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>
	<form name="LoginForm"
		action='<c:url value = "j_spring_security_check"/>' 'method="post"'></form>
	<table>
		<tr>
			<td colspan="2">Login</td>
		</tr>
		<tr>
			<td colspan="2">${msg}</td>
		</tr>
		<tr>
			<td>Username:</td>
			<td><input type="text" name="username" /></td>

			<td>password:</td>
			<td><input type="password" username="password" /></td>
		</tr>
		<tr>
			<td>Remember Me:</td>
			<td><inputtype ="Checkbox" name="remeber-me"></td>

		</tr>
		<tr>
			<td></td>
			<td>
				<button type="submit">Login</button>
			</td>
		</tr>
		<tr>
			<td><a href='<c:url value = "/user/signup"/>'>Signup</a></td>
		</tr>
	</table>
</body>
</html>
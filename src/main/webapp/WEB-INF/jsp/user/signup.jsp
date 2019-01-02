<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Signup</title>
</head>
<body>
<spring:url value "/user/register" var="registerURL" />
<form action="${registerURL}" modelAttribute="userForm" method ="post">
<label>Username: </label>
<form:input path = "username" type = "text" />
<form:errors path = "username" />
<br/>
<label>Password: </label>
<form:password path="password" type />
<form:errors path= "password" />
<br/>
<label>Confirm password:</label>
<form:password path= "confirmPassword" />
<form:errors path "confirmPassword"/>
<br/>
<button type= "submit">Signup</button>

</form>

</body>
</html>
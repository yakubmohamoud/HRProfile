<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix= "c" url = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Pass</title>
</head>
<body>
<spring:url value = "/user/save" var = "saveURL"/>

<form method= "post" modelAttribute="user" action = "${saveURL}">
<table border = "1">
<tr> 
<td colspan = "2"> ${msg}</td>
</tr>
<tr>
<td>Username: </td>
<td>${user.username}</td>
</tr>
<tr>
<td>Password:</td>
<td><form:password path="password" /></td>
</tr>
<tr>
<td></td>
<td><button type ="submit">change password</button></td>
</tr>
</table>

</form>



</body>
</html>
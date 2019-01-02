<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix= "c" url = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Page</title>
</head>
<body>
<a href = 'c:url valule = "/logout" />' >Logout</a>
<br/>
<table>
	<tr>
	<td>Username</td>
	<td>Action</td>
	</tr>
	<c:forEach items = "${list }" var = "user" />
	<tr> 
	<td> $(user.username) </td>
	<td> 
	<spring:url value = "/user/changePass" var = "{changePassURL}" />
	<a href = "$ {changePassURL}/${user.username}"> Change Pass</a>
	</td>
	</tr>
	
	
	
</table>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix= "c" url = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<a href='<c:url value ="/Logout"/>' >logout</a>
<h1>Welcome<c:if test ="${pageContext.request.userPrincipal.name != null }"> ${pageContext.request.userPrincipal.name }</c:if> </h1>
<br/>
<a href = '<c:url value = "/user/list" />' >Users List</a>
</body>
</html>
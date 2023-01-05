<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="color:blue;width:50;height:50;text-align:center;">Menu Page</h1>
<table align="center" style="color:green;">
<c:forEach items="${foodItems}" var="element">

<tr>
	<td>${element.name} </td>
	<td>${element.price}</td>
</tr>
</c:forEach>
</table>

</body>
</html>
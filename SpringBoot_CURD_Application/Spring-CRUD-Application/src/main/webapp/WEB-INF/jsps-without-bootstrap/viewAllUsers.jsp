<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
 <%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>create user</title>
</head>
<body>
<h1>Spring CRUD Application</h1>
<h2>View All Users</h2>
<table>
	<tr>
		<th>Id</th>
		<th>Login Id</th>
		<th>Name</th>
		<th>Status</th>
	</tr>
	<tbody>
		<c:forEach items="${users}" var="user">
		<tr>
			<td>${user.id }</td>
			<td>${user.loginid}</td>
			<td>${user.name}</td>
			<td>${user.status}</td>
			<td><a href="editUser?id=${user.id}">Edit</a> </td>
			<td><a href="deleteUser?id=${user.id}">Delete</a> </td>
		</tr>
		</c:forEach>
		
	</tbody>
<a href="createUser">CreateUser</a>
</table>


</body>

</html>
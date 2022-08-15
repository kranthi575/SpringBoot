<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
 <%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<title>View all </title>
</head>
<body>
<h1 class="text-center">Spring CRUD Application</h1>

<div class="container">
	<h2>View All Users</h2>
	
	
		<table class="table table-hover">
			<tr class="table-primary">
				<th>Id</th>
				<th>Login Id</th>
				<th>Name</th>
				<th>Status</th>
				<th></th>
				<th></th>
				
			</tr>
			<tbody>
				<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.id }</td>
					<td>${user.loginid}</td>
					<td>${user.name}</td>
					<td>${user.status}</td>
					<td><a class="btn btn-primary"  href="editUser?id=${user.id}" role="button">Edit</a></td>
					<td><a class="btn btn-primary"  href="deleteUser?id=${user.id}" role="button">Delete</a></td>
				</tr>
				</c:forEach>
				
			</tbody>
		</table>
		
		<a class="btn btn-warning" href="createUser">CreateUser</a>	
</div>




</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>create user</title>
</head>
<body>
<h1>Spring CRUD Application</h1>
<h2>Edit User</h2>
<form action="updateUser" method="post">
Id:<input type="text" name="id" readonly="readonly" value="${user.id}"><br>
LoginId:<input type="text" name="loginid" value="${user.loginid }"><br>
Name:<input type="text" name="name" value="${user.name}"><br>
Status:Active<input type="radio" name="status"  value="ACTIVE">
	   Inactive<input type="radio" name="status"  value="INACTIVE"><br>
	   
<input type="submit" value="UpdateUser">
</form>
<a href="viewAll">View All</a>
</html>
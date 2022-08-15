<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<title>create user</title></head>
<body>
<h1 class="text-center">Spring CRUD Application</h1>

<div class="container">
<h2>Create User</h2>

	<div class="row">
	<form  action="saveUser" method="post">
	
		<div class="form-group row">
    		<label  class="col-sm-2 col-form-label">ID:</label>
   			 <div class="col-sm-10">
      			<input type="text" name="id" readonly="readonly" class="form-control"><br>
    		 </div>
  		</div>
		<div class="form-group row">
    		<label  class="col-sm-2 col-form-label">LoginId:</label>
   			 <div class="col-sm-10">
      			<input  type="text" name="loginid" class="form-control"><br>
    		 </div>
  		</div>	
		<div class="form-group row">
    		<label  class="col-sm-2 col-form-label">Name:</label>
   			 <div class="col-sm-10">
      			<input  type="text" name="name" class="form-control"><br>
    		 </div>
  		</div>
  		<label  class="col-sm-2 col-form-label">Status:</label>		
		<div class="form-group row">
  			<input class="form-check-input" type="radio" name="status" value="ACTIVE">
  			<label class="form-check-label" >
    		Active
  			</label>
		</div>
		<div class="form-group row">
  			<input class="form-check-input" type="radio" name="status" value="INACTIVE">
  			<label class="form-check-label" >
    		Inactive
  			</label>
		</div>
		<div class="alert alert-success" role="alert">
		${msg}
		</div>   
		<input type="submit" value="SAVE">
	</form>
	</div>	
	<a class="btn btn-primary"  href="viewAll" role="button">View All Users</a>	
	
</div>

</body>

</html>
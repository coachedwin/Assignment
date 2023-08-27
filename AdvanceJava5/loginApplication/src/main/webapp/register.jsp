<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style>
	.login-form {
		width: 340px;
    	margin: 50px auto;
	}
    .login-form form {
    	margin-bottom: 15px;
        background: #f7f7f7;
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        padding: 30px;
    }

    .btn {        
        font-size: 15px;
        font-weight: bold;
    }
   
</style>
</head>

<body>
	<div class="login-form">
		<h2 class="text-left">Register</h2>
		<form action="register" method="post">
		
		
		<div class="form-group">
			<br> Username :  <input type="text" class="form-control" name="username" required minlength="5" maxlength="50"><br>
	    </div>
			<br> Password :  <input type="password" class="form-control" name="password" required minlength="5" maxlength="50"><br>
			<br> <input type="submit" value="Register"  class="pull-right">
		</form>
	
</body>
</html>
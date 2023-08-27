<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
<div style="text-align: center;text-decoration: underline;font-size:40px;">
</div>
<form action="NewLoginDaoPath" method="post">
		<div class="card" style="width: 38rem; align-self: center;">
			<div class="card-header" style="background-color: #d4d4d4;">
				Sign Up</div>
			<br>
			<div class="mb-2">
				Username: &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <input
					type="text" name="uname" required="required">
			</div>
			<div class="mb-4">
				Password: &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <input
					type="password" name="pwd" required="required">
			</div>
			
			<div class="card-footer" style="background-color: #d4d4d4;">
				<button type="submit" class="btn btn-primary"
					style="color: blue; background-color: white;">REGISTER>></button>
			</div>
		</div>
	</form>
	

</body>
</html>
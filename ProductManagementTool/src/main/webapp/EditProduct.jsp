<%@page import="com.nagarro.servletjsp.dao.SaveProductDao,com.nagarro.servletjsp.pojo.*"%>
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
<%String productId=request.getParameter("prodId");
Product product=SaveProductDao.getProductById(productId);
%>
<form action="EditProductPath" style="margin-left: 10px" method="post" enctype="multipart/form-data">
		<div class="card" style="width: 38rem; align-self: center;">
			<div class="card-header" style="background-color: #d4d4d4;">
				Edit Product</div>
			<br>
			<label for="country">ID</label>
          <input type="text"name="id" value="<%=productId %>" readonly><br>
		
		<label>Title&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label> 
		<input type="text" name="title"value="<%=product.getTitle()%>" required="required"><br> <label>Quantity</label>
		<input type="text" name="qty" value="<%=product.getQuantity() %>"required="required"><br>
		<label>Size&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label> <input
			type="text" name="size"value="<%=product.getSize() %>" required="required"><br> 
			<label>Image</label>
		<input type="file" id="fileUpload" name="imge" accept="image/*"
			required="required"><br>	
		<br>		
			<div class="card-footer" style="background-color: #d4d4d4;">
				<button type="submit" class="btn btn-primary"
					style="color: blue; background-color: white;">UPDATE</button>
			</div>
		</div>
	</form>

</body>
</html>
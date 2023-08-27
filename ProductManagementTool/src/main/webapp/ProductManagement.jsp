<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="com.nagarro.servletjsp.dao.*,com.nagarro.servletjsp.pojo.*,java.util.List,java.io.ByteArrayInputStream,java.awt.image.BufferedImage,javax.imageio.ImageIO,java.io.File" %>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="style.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
<%int isize=0;if(request.getAttribute("isize")!=null){ isize=(Integer)request.getAttribute("isize");} %>
	<form action="LoginModule.jsp">
		<div class="row">
			<div class="col-sm-8">
				<h2 style="color: black; text-align: right;">
					<b>Product Management Tool</b>
				</h2>
			</div>
			<div class="col-sm-4">
				<h4 style="text-align: right; margin-top: 20px; margin-right: 10px;">
					Hi&nbsp<%
				out.println(request.getParameter("uname"));
				%>
					<button type="submit" class="btn btn-primary"
						style="color: blue; background-color: white;">Logout</button>
				</h4>
			</div>
		</div>
	</form>
	<br>
	<br>
	<%String user=request.getParameter("uname"); %>
	<form action="ProductDaoPath" style="margin-left: 10px" method="post" enctype="multipart/form-data">
	
		<h4>
			<b>Please enter product details to add to stock:</b>
		</h4>
		<label>ProductID</label> 
		<input type="text" name="id" required="required"><br>
		<label>Title&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label> 
		<input type="text" name="title" required="required"><br> <label>Quantity</label>
		<input type="number" name="qty" required="required"><br>
		<label>Size&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</label> <input
			type="number" name="size" required="required"><br> 
			<label>Image</label>
		<input type="file" id="fileUpload" name="img" accept="image/*"
			required="required"><br>
			<label>Size Count</label>
          <input type="number"value="<%=isize%>" readonly><br><br>
            <input type="hidden" name="uname" value="<%=user%>" />
		<button type="submit" class="btn btn-primary"
			style="color: white; background-color: green;">Save</button>
		<br>
	</form>
	<br>
	
	<table align="center" border="2">
		<thead>
			<tr>
				<th style="width: 100px; text-align: center;">S.no.</th>
				<th style="width: 250px; text-align: center;">Title</th>
				<th style="width: 150px; text-align: center;">Quantity</th>
				<th style="width: 150px; text-align: center;">Size</th>
				<th id="myImg" style="width: 350px; text-align: center;">Image</th>
				<th colspan="2" style="width: 400px; text-align: center;">Actions</th>
			</tr>
			<%
			List<Product> productList=SaveProductDao.getAllProducts();
				
					
				  for(Product p:productList){
			%>
			<tr>
				<td style="text-align: center;"></td>
				<td style="text-align: center;"><%=p.getTitle() %></td>
				<td style="text-align: center;"><%=p.getQuantity() %></td>
				<td style="text-align: center;"><%=p.getSize() %></td>
				<td style="text-align: center;"><img src="<%=p.getPath() %>"
					alt="" border=3 height=200 width=200></img></td>
				<td style="text-align: center;"><button onclick="location.href='EditProduct.jsp?prodId=<%=p.getId()%>'">
						<img
							src="https://img.icons8.com/ios-glyphs/30/000000/edit--v1.png" />
					</button>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					<button onclick="location.href='DeleteProduct.jsp?prodId=<%=p.getId()%>'">
						<img
							src="https://img.icons8.com/ios-glyphs/30/000000/filled-trash.png" />
					</button></td>

			</tr>
			<%}
			  %>
			
	</table>

</body>
</html>












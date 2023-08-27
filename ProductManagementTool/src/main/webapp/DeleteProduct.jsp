<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page
	import="com.nagarro.servletjsp.dao.*,org.hibernate.Query,org.hibernate.Session,org.hibernate.Transaction,com.nagarro.servletjsp.util.ProductDbUtil"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%String productId=request.getParameter("prodId");
Session sesssion=ProductDbUtil.getSessionFactory().openSession();
Query q=sesssion.createQuery("delete from Product p where p.id=:id").setParameter("id",productId);
q.executeUpdate();
Transaction tx=sesssion.beginTransaction();
tx.commit();
sesssion.close();
RequestDispatcher rd=request.getRequestDispatcher("ProductManagement.jsp");
rd.forward(request, response);
%>
</body>
</html>
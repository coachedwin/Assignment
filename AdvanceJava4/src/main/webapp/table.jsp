<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ page import="com.nagarro.model.TshirtModel,java.util.*" %>    
<!DOCTYPE html>
<html>
<head>
<style>
#customers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}
</style>
</head>
<body>

<h1>T-shirt options available according to your choice are:</h1>
<% List<TshirtModel> td=(List<TshirtModel>)request.getAttribute("tm");
if(td.isEmpty()){
%>
<h2 align="Center">No options available according to your choice</h2>
<%}
else{
%>
<table id="customers">
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Colour</th>
    <th>Gender_Recomendation</th>
    <th>Size</th>
    <th>Price</th>
    <th>Rating</th>
 </tr>
 
 <%for (TshirtModel t:td){%>
 <tr>
    <td><%
 out.println(t.getId());
 %>
    </td>
    <td><%
 out.println(t.getName());
 %>
    </td>
    <td><%
 out.println(t.getColor());
 %>
    </td>
    <td><%
 out.println(t.getGender());
 %>
    </td>
    <td><%
 out.println(t.getSize());
 %>
    </td>
    <td><%
 out.println(t.getPrice());
 %>
    </td>
    <td><%
 out.println(t.getRating());
 %>
    </td>
  </tr>
 <%}
 }%>
 
</table>
<a align="right" href="Buy.jsp">Back to the Search Page</a>
</body>
</html>



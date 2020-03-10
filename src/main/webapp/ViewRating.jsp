<%@page import="com.chainsys.hmsapplication.service.ServiceOverall"%>
<%@page import="com.chainsys.hmsapplication.model.Overallrating"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.chainsys.hmsapplication.dao.impl.Impoverall"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
.buttons {
	background-color: brown;
	border: none;
	color: white;
	padding: 10px 20px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}
</style>
<body>
<!--Impoverall imp=new Impoverall();  -->
<% 
ArrayList<Overallrating> lists = (ArrayList)request.getAttribute("list");
%>
<form action="ViewRatingServlet">
<table border="1">
<thead>
<tr>
<th>Doctor ID</th>
<th>Rating</th>
</tr>
</thead>
<tbody>
<%
for (Overallrating rs : lists) {
%>
<tr>
<td><%=rs.getDoctor_id() %></td>
<td><%=rs.getRating() %></td>
</tr>

<%
}
%>

</form>
</tbody>
</table>
<a href="index.jsp" class="buttons">MAIN MENU</a>

</body>
</html>
<%@page import="com.vijaysankar.hmgsystems.splzations.Splzationlist"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.vijaysankar.hmgsystems.splzations.Impspecialization"%>
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
<%
Impspecialization imp= new Impspecialization();
ArrayList<Splzationlist> list=imp.viewspl();
%>

<form action = "ViewSpecializationServlet">
<table border="1">
<thead>
<tr>
<th>Specialization ID</th>
<th>Specialization Name</th>
</tr>
</thead>
<tbody>
<%
for (Splzationlist rs : list) {
%>
<tr>
<td><%=rs.getSplzationid() %></td>
<td><%=rs.getSplzationname() %></td>
</tr>

<%
}
%>
<a href="index.jsp" class="buttons">MAIN MENU</a>

</body>
</html>
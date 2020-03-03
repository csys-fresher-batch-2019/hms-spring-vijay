<%@page import="java.util.ArrayList"%>
<%@page import="com.chainsys.hmsapplication.dao.impl.Impappointment"%>
<%@page import="com.chainsys.hmsapplication.model.Appointmentlist"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
.button {
	background-color: brown;
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}
</STYLE>
<body>
<%
Impappointment obj = new Impappointment();
ArrayList<Appointmentlist> list = obj.viewapp();
%>
<form action = "ViewAllAppointmentServlet">
<table border="1">
<thead>
<tr>
<th>Appointment ID</th>
<th>Patient ID</th>
<th>Purpose</th>
<th>Doctor ID</th>
<th>Appointment Date</th>
<th>Appointment Time</th>
<th>Status</th>
<th>Visited</th>
</tr>
</thead>
<tbody>
<%
for (Appointmentlist rs : list) {
%>
<tr>
<td><%=rs.getAppid()%></td>
<td><%=rs.getPatientid()%></td>
<td><%=rs.getPurpose()%></td>
<td><%=rs.getDoctorid()%></td>
<td><%=rs.getAppdate()%></td>
<td><%=rs.getApptime()%></td>
<td><%=rs.getStatus() %></td>
<td><%=rs.getVisited() %></td>
</tr>

<%
}
%>
</form>
</body></table><br>
<a href="index.jsp" class="button">MAIN MENU</a>
</html>
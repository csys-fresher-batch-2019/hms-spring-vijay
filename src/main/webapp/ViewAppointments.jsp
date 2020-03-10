<%@page import="com.chainsys.hmsapplication.model.Appointment"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@page import="com.chainsys.hmsapplication.service.ServiceAppointment"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
.button {
	background-color: orange;
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
	ArrayList<Appointment> lists = (ArrayList)request.getAttribute("list");
%>
<form action = "AppointmentStatusServlet">
<table border="1">
<thead>
<tr>
<th>Appointment ID</th>
<th>Patient ID</th>
<th>Purpose</th>
<th>Doctor ID</th>
<th>Appointment Date</th>
<th>Appointment Time</th>
<th>Visited</th>
</tr>
</thead>
<tbody>
<%
	for (Appointment rs : lists) {
%>
<tr>
<td><%=rs.getAppointmentId()%></td>
<td><%=rs.getPatientId()%></td>
<td><%=rs.getPurpose()%></td>
<td><%=rs.getDoctorId()%></td>
<td><%=rs.getAppointmentDate()%></td>
<td><%=rs.getAppointmentTime()%></td>
<td><%=rs.getStatus()%>
<td><button name="pid" type ="submit" class="button" value=<%=rs.getAppointmentId()%> >Approve</button></td>
</tr>

<%
}
%>

</tbody>
</table>
</form>
<a href="index.jsp" class="buttons">MAIN MENU</a>

</body>
</html>
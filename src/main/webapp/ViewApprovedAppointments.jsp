<%@page import="com.chainsys.hmsapplication.service.ServiceAppointment"%>
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
	background-color: green;
	border: none;
	color: white;
	padding: 10px 15px;
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
	padding: 10px 15px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}
</style>
<body>

<!--  Impappointment obj = new Impappointment();-->

<%
ServiceAppointment obj=new ServiceAppointment();
ArrayList<Appointmentlist> list = obj.viewstatus();
%>
<form action = "AppointmentVisitedServlet">
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
<td><%=rs.getVisited() %></td>
<td><button name="yid" type ="submit" class="button" value=<%=rs.getAppid()%> >Yes</button></td>
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
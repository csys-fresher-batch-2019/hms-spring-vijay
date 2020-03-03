<%@page import="com.chainsys.hmsapplication.service.ServicePatient"%>
<%@page import="java.util.List"%>
<%@page import="com.chainsys.hmsapplication.model.Patientreglist"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.chainsys.hmsapplication.dao.impl.ImpPatients"%>
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
	<!-- ImpPatients pat=new ImpPatients(); -->
	<%
		ServicePatient pat = new ServicePatient();
		ArrayList<Patientreglist> reg = pat.viewpatient();
	%>

	<form action="ViewRegisteredServlet">
		<table border="1">
			<thead>
				<tr>
					<th>Patient ID</th>
					<th>Patient Name</th>
					<th>Adharcard Number</th>
					<th>Date of Birth</th>
					<th>gender</th>
					<th>Phone Number</th>
					<th>Patient Registerd Date</th>
				</tr>
			</thead>
			<tbody>
				<%
					for (Patientreglist rs : reg) {
				%>
				<tr>
					<td><%=rs.getPatientId()%></td>
					<td><%=rs.getPatientname()%></td>
					<td><%=rs.getAdharno()%></td>
					<td><%=rs.getDob()%></td>
					<td><%=rs.getGender()%></td>
					<td><%=rs.getPhoneno()%></td>
					<td><%=rs.getRegdate()%></td>

				</tr>

				<%
					}
				%>
				<a href="index.jsp" class="buttons">MAIN MENU</a>
</body>
</html>
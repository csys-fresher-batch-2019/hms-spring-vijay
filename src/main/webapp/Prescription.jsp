<%@page import="com.chainsys.hmsapplication.service.ServiceDoctor"%>
<%@page import="com.chainsys.hmsapplication.dao.impl.Impdoctor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.chainsys.hmsapplication.dao.Interfacedoctor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="text-align: center">
	<h2>PRESCRIPTION</h2>
	<form action="PrescriptionServlet">

		<table align="center">
			<tr>
				<td>Enter Patient name:
				<td><input type="text" name="patientname"
					placeholder="enter name" required autofocus />
			</tr>


			<%
				ArrayList<String> doctorslist = (ArrayList) request.getAttribute("doctorlist");
			%>

			<tr>
				<td>Enter Doctor name:
				<td><input type="text" name="doctorname" list="doctorlist"
					required> <datalist id="doctorlist">

						<%
							for (String d : doctorslist) {
						%>
						<option value="<%=d%>"><%=d%></option>
						<%
							}
						%>
					</datalist>
			</tr>
			<tr>
				<td>Enter comments:
				<td><input type="text" name="comments"
					placeholder="comments please">
			</tr>
			<tr>
				<td>Any other fee :
				<td><input type="number" name="otherfee"
					placeholder="other fee" min=0 required />
			</tr>
		</table>
		<br>
		<button type="submit">submit</button>
	</form>
</body>
</html>
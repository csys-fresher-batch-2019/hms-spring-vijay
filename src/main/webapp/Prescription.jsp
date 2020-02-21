<%@page import="com.vijaysankar.hmgsystems.doctors.Impdoctor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.vijaysankar.hmgsystems.doctors.Interfacedoctor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="text-align: center">
	<h2>PRESCRIPTION</h2>
	<form action="PrescriptionServlet">
		<CENTER>
			<table>
				<tr>
					<td>Enter Patient name:
					<td><input type="text" name="patientname"
						placeholder="enter name" required autofocus />
				</tr>
				<%
					Impdoctor doc = new Impdoctor();
					ArrayList<String> doctorlist = doc.doclist();
				%>
				<tr>
					<td>Enter Doctor name:
					<td><input type="text" input name="doctorname"
						list="doctorlist" required> <datalist id="doctorlist">

						<%
							for (String d : doctorlist) {
						%>
						<option value="<%=d%>"><%=d%></option>
						<%
							}
						%> </datalist>
				</tr>
				<tr>
					<td>Enter comments:
					<td><input type="text" name="comments"
						placeholder="comments please">
				</tr>
				<tr>
					<td>Any other fee :
					<td><input type="number" name="otherfee"
						placeholder="other fee" min=0 required/>
				</tr>
			</table>
		</CENTER><br>
		<button type="submit">submit</button>
	</form>
</body>
</html>
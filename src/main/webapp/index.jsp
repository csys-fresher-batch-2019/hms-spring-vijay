<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
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
.header {
  background-color: black;
  color: yellow;
  padding: 15px;
}
.grid-container {
  display: grid;
  grid-template-columns: auto auto auto auto ;
  grid-gap: 20px;
  padding: 30px;
}

</style>

<body style="text-align:center" bgcolor="moccasin">
<div class="header">
  <h2>WELCOME - BOOK AN APPOINTMENT</h2>
</div>
<div class="grid-container">
<div><a href="Registration.jsp" class="button">NEW REGISTERATION</a></div>
<div><a href="AppointmentLoadServlet" class="button">APPOINTMENT</a></div>
<div><a href="AddSpecialization.jsp" class="button"> ADD SPECIALIZATION</a></div>
<div><a href="AddDoctorLoadServlet" class="button"> ADD DOCTOR</a></div>
<div><a href="PrescriptionLoadServlet" class="button">PRESCRIPTION</a></div>
<div><a href="ViewRegisteredLoadServlet" class="button">VIEW REGISTERED PATIENTS</a></div>
<div><a href="ViewAppointmentsLoadServlet"class="button"> VIEW APPOINTMENTS</a></div>
<div><a href="ViewApprovedAppointmentsLoadServlet"class="button"> VIEW APPROVED APPOINTMENTS</a></div>
<div><a href="ViewAllAppointmentLoadServlet"class="button"> VIEW ALL APPOINTMENTS</a></div>
<div><a href="ViewSpecializationLoadServlet" class="button"> VIEW SPECIALIZATION</a></div>
<div><a href="ViewRatingLoadServlet" class="button"> VIEW RATING</a></div>
<div><a href="ViewDoctorsLoadServlet" class="button"> VIEW DOCTOR LIST</a></div>

</body>
</html>

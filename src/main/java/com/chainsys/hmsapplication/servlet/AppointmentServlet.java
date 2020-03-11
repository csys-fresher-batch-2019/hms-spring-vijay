package com.chainsys.hmsapplication.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Appointment;
import com.chainsys.hmsapplication.randomnumber.Randomnumber;
import com.chainsys.hmsapplication.service.ServiceAppointment;
import com.chainsys.hmsapplication.util.Testconfirm;

@WebServlet("/AppointmentServlet")
public class AppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String patientIdstr = request.getParameter("patientid");
		String purpose = request.getParameter("purpose");
		String doctorid = request.getParameter("doctorid");
		String Appdate = request.getParameter("app");
		String Apptime = request.getParameter("time");
		String Email = request.getParameter("email");

		Appointment list = new Appointment();

		list.setAppointmentId(Randomnumber.getrandom());
		int patientId = Integer.parseInt(patientIdstr);
		list.setPatientId(patientId);
		list.setPurpose(purpose);
		int doctorId = Integer.parseInt(doctorid);
		list.setDoctorId(doctorId);
		LocalDate l = LocalDate.parse(Appdate);
		list.setAppointmentDate(l);
		list.setAppointmentTime(Apptime);
		list.setEmail(Email);

		ServiceAppointment service = new ServiceAppointment();
		try {
			service.addappointment(list);
			Testconfirm.main(list.getAppointmentId(), list.getPatientId(), list.getDoctorId(),
					list.getAppointmentDate(), list.getAppointmentTime(), list.getEmail());

		} catch (Dbexception e1) {
			e1.printStackTrace();
		}
		response.sendRedirect("Mailsent.jsp");

	}
}

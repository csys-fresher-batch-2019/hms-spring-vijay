package com.chainsys.hmsapplication.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.hmsapplication.model.PatientRegistration;
import com.chainsys.hmsapplication.service.ServiceRegistration;

@WebServlet("/RegistrationServlet")

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String Name = request.getParameter("name");
		String Adhar = request.getParameter("adhar");
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");
		String phno = request.getParameter("mobile number");

		ServiceRegistration obj = new ServiceRegistration();

		PatientRegistration p1 = new PatientRegistration();

		p1.setPatientName(Name);
		long adhar = Long.parseLong(Adhar);
		p1.setAdharNo(adhar);
		LocalDate st = LocalDate.parse(dob);
		p1.setDob(st);
		p1.setGender(gender);
		long ph = Long.parseLong(phno);
		p1.setPhoneNo(ph);

		try {
			obj.appendPatient(p1);
			request.setAttribute("infoMessage", "Patient Registered");
		} catch (Exception e) {
			request.setAttribute("infoMessage", "Patient Not Registered");
		}

		RequestDispatcher rd = request.getRequestDispatcher("Registration.jsp");
		rd.forward(request, response);

	}

}

package com.chainsys.hmsapplication.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.hmsapplication.model.Patientreglist;
import com.chainsys.hmsapplication.service.ServicePatient;
@WebServlet("/Registrationservlet")

public class Registrationservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Name=request.getParameter("name");
		String Adhar=request.getParameter("adhar");
		String dob=request.getParameter("dob");
		String gender=request.getParameter("gender");
		String phno=request.getParameter("mobile number");
		
			
			//ImpPatients obj=new ImpPatients();
			ServicePatient obj= new ServicePatient();
			
			Patientreglist p1= new Patientreglist();
			
			p1.setPatientname(Name);
			long adhar = Long.parseLong(Adhar);
			p1.setAdharno(adhar);
			LocalDate st= LocalDate.parse(dob);
			p1.setDob(st);
			p1.setGender(gender);
			long ph=Long.parseLong(phno);
			p1.setPhoneno(ph);
			
			try {
				obj.addpatient(p1);
				request.setAttribute("infoMessage", "Patient Registered");
			} catch (Exception e) {
				request.setAttribute("infoMessage", "Patient Not Registered");
			}
			
			RequestDispatcher rd=request.getRequestDispatcher("Registration.jsp");
			rd.forward(request, response);
			
			
	}

	
}

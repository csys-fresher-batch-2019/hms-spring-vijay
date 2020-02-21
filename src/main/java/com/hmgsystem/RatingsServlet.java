package com.hmgsystem;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vijaysankar.hmgsystems.dbexception.Dbexception;
import com.vijaysankar.hmgsystems.userrating.Impuserrating;
import com.vijaysankar.hmgsystems.userrating.Userrating;
@WebServlet("/RatingsServlet")

public class RatingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String patientid = request.getParameter("patientid");
		String doctorid = request.getParameter("doctorid");
		String rating = request.getParameter("rating");

		Impuserrating imp = new Impuserrating();
		Userrating ur = new Userrating();
		int patient = Integer.parseInt(patientid);
		ur.setPatient_id(patient);
		int doctor = Integer.parseInt(doctorid);
		ur.setDoctor_id(doctor);
		int rtg = Integer.parseInt(rating);
		ur.setRating(rtg);
		try {
			imp.addrating(ur);
		} catch (Dbexception e) {
			e.printStackTrace();
		}
		response.sendRedirect("index.jsp");
	}
}

package com.chainsys.hmsapplication.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.UserRating;
import com.chainsys.hmsapplication.service.ServiceUserRating;

@WebServlet("/RatingServlet")

public class RatingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String patientid = request.getParameter("patientid");
		String doctorid = request.getParameter("doctorid");
		String rating = request.getParameter("rating");

		ServiceUserRating imp = new ServiceUserRating();
		UserRating ur = new UserRating();
		int patient = Integer.parseInt(patientid);
		ur.setPatientId(patient);
		int doctor = Integer.parseInt(doctorid);
		ur.setDoctorId(doctor);
		int rtg = Integer.parseInt(rating);
		ur.setRating(rtg);
		try {
			imp.addRating(ur);
		} catch (Dbexception e) {
			e.printStackTrace();
		}
		response.sendRedirect("index.jsp");
	}
}

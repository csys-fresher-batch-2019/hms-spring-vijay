package com.chainsys.hmsapplication.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Doctor;
import com.chainsys.hmsapplication.service.ServiceDoctor;

@WebServlet("/DoctorServlet")
public class DoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String Docid = request.getParameter("docid");
		String Docname = request.getParameter("docname");
		String Splid = request.getParameter("splid");
		String Fee = request.getParameter("fee");

		Doctor doc = new Doctor();

		ServiceDoctor docs = new ServiceDoctor();
		int id = Integer.parseInt(Docid);
		doc.setDoctorId(id);
		doc.setDoctorName(Docname);
		int spl = Integer.parseInt(Splid);
		doc.setSpecializationId(spl);
		int fees = Integer.parseInt(Fee);
		doc.setConsultationFee(fees);

		try {
			docs.adddoctor(doc);
			request.setAttribute("infoMessage", "Doctor Added");
		} catch (Dbexception e) {
			request.setAttribute("errorMessage", "Doctor Not Added ");
		}

		RequestDispatcher rd = request.getRequestDispatcher("AddDoctor.jsp");
		rd.forward(request, response);
	}
}

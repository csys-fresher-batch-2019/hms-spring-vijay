package com.chainsys.hmsapplication.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.service.ServiceDoctor;

@WebServlet("/PrescriptionLoadServlet")
public class PrescriptionLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServiceDoctor doc = new ServiceDoctor();
		try {
			List<String> doctorlist = doc.doclist();
			request.setAttribute("doctorlist", doctorlist);

			RequestDispatcher sp = request.getRequestDispatcher("Prescription.jsp");
			sp.forward(request, response);

		} catch (Dbexception e) {
			e.printStackTrace();
		}
	}
}

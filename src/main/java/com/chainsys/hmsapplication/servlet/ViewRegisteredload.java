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
import com.chainsys.hmsapplication.model.Patientreglist;
import com.chainsys.hmsapplication.service.ServicePatient;

@WebServlet("/ViewRegisteredload")
public class ViewRegisteredload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		ServicePatient pat = new ServicePatient();
		try {
			List<Patientreglist> list = pat.viewpatient();

			request.setAttribute("list", list);

			RequestDispatcher sp = request.getRequestDispatcher("ViewRegisteredPatients.jsp");
			sp.forward(request, response);
		} catch (Dbexception e) {

			e.printStackTrace();
		}
	}

}

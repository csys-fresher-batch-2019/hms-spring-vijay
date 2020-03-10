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
import com.chainsys.hmsapplication.model.Appointment;
import com.chainsys.hmsapplication.service.ServiceAppointment;

@WebServlet("/ViewApprovedAppointmentsLoadServlet")
public class ViewApprovedAppointmentsLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		ServiceAppointment obj = new ServiceAppointment();
		try {
			List<Appointment> list = obj.viewstatus();

			request.setAttribute("list", list);

			RequestDispatcher sp = request.getRequestDispatcher("ViewApprovedAppointments.jsp");
			sp.forward(request, response);
		} catch (Dbexception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

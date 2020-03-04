package com.chainsys.hmsapplication.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.hmsapplication.dao.impl.Impappointment;
import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.service.ServiceAppointment;
@WebServlet("/AppointmentVisitedServlet")
public class AppointmentVisitedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String s = request.getParameter("yid");
		int yid = Integer.parseInt(s);
		System.out.println(s);
		//Impappointment impapp = new Impappointment();
		ServiceAppointment impapp= new ServiceAppointment();
		try {
			impapp.updatevisited(yid);
		} catch (Dbexception e) {
			e.printStackTrace();
		}
		RequestDispatcher obj = request.getRequestDispatcher("ViewApprovedAppointments.jsp");
		obj.forward(request, response);

	}

}

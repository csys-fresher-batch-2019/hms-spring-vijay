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
import com.chainsys.hmsapplication.model.PatientRegistration;
import com.chainsys.hmsapplication.service.ServiceRegistration;

@WebServlet("/ViewRegisteredLoadServlet")
public class ViewRegisteredLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("not done");
		ServiceRegistration pat = new ServiceRegistration();
		try {
			List<PatientRegistration> list = pat.viewpatient();
			System.out.println("not responded");
			request.setAttribute("list", list);
			
			RequestDispatcher sp = request.getRequestDispatcher("ViewRegisteredPatients.jsp");
			sp.forward(request, response);
		} catch (Dbexception e) {

			e.printStackTrace();
		}
	}
}
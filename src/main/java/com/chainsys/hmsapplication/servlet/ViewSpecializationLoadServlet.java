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
import com.chainsys.hmsapplication.model.Specialization;
import com.chainsys.hmsapplication.service.ServiceSplzations;

@WebServlet("/ViewSpecializationLoadServlet")
public class ViewSpecializationLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher sp = null;
		ServiceSplzations imp = new ServiceSplzations();
		try {
			List<Specialization> list = imp.viewspl();

			request.setAttribute("list", list);
			sp = request.getRequestDispatcher("ViewSpecialization.jsp");
			sp.forward(request, response);
		} catch (Dbexception e) {
			e.printStackTrace();
		}
	}
}

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
import com.chainsys.hmsapplication.service.ServiceSplzations;

@WebServlet("/AddDoctorload")
public class AddDoctorload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		ServiceSplzations splzation = new ServiceSplzations();
		try {
			List<Integer> spl = splzation.getspl();
			request.setAttribute("spl", spl);

			RequestDispatcher sp = request.getRequestDispatcher("AddDoctor.jsp");
			sp.forward(request, response);
		} catch (Dbexception e) {
			e.printStackTrace();
		}

	}

}

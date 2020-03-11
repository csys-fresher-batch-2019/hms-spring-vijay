package com.chainsys.hmsapplication.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.service.ServiceRegistration;

@WebServlet("/ViewRegisteredServlet")

public class ViewRegisteredServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServiceRegistration patient = new ServiceRegistration();
		try {
			patient.viewpatient();
		} catch (Dbexception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

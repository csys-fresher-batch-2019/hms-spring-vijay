package com.chainsys.hmsapplication.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Splzationlist;
import com.chainsys.hmsapplication.service.ServiceSplzations;

@WebServlet("/SpecializationServlet")

public class SpecializationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("specialid");
		String name = request.getParameter("specialname");

		Splzationlist spl = new Splzationlist();
		//Impspecialization imp = new Impspecialization();
		ServiceSplzations imp=new ServiceSplzations();
		int add = Integer.parseInt(id);
		spl.setSplzationid(add);
		spl.setSplzationname(name);
		try {
			imp.addspecialization(spl);
			response.sendRedirect("SpecialAdded.jsp");
		} catch (Dbexception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

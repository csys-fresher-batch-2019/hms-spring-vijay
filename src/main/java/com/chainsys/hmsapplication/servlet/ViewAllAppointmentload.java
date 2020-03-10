package com.chainsys.hmsapplication.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Appointmentlist;
import com.chainsys.hmsapplication.service.ServiceAppointment;


@WebServlet("/ViewAllAppointmentload")
public class ViewAllAppointmentload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		ServiceAppointment obj=new ServiceAppointment();
		
		try {
			ArrayList<Appointmentlist> list= obj.viewapp();
			
			request.setAttribute("list", list);
			
			RequestDispatcher sp= request.getRequestDispatcher("ViewAllAppointments.jsp");
			sp.forward(request, response);
		} catch (Dbexception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

	
}

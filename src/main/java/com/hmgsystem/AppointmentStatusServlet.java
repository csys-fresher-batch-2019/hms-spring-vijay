package com.hmgsystem;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vijaysankar.hmgsystems.appointment.Impappointment;
import com.vijaysankar.hmgsystems.dbexception.Dbexception;
@WebServlet("/AppointmentStatusServlet")
public class AppointmentStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String s = request.getParameter("pid");
		int pid = Integer.parseInt(s);
		System.out.println(s);
		Impappointment impapp=new Impappointment();
		try {
			impapp.updateappointment(pid);
			RequestDispatcher obj=request.getRequestDispatcher("ViewAppointments.jsp");
			obj.forward(request, response);

		} catch (Dbexception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}

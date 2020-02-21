package com.hmgsystem;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vijaysankar.hmgsystems.dbexception.Dbexception;
import com.vijaysankar.hmgsystems.patientreg.ImpPatients;
@WebServlet("/ViewRegisteredServlet")

public class ViewRegisteredServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	ImpPatients patient=new ImpPatients();
	try {
		patient.viewpatient();
	} catch (Dbexception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	

}

package com.hmgsystem;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vijaysankar.hmgsystems.dbexception.Dbexception;
import com.vijaysankar.hmgsystems.doctors.Doctorlist;
import com.vijaysankar.hmgsystems.doctors.Impdoctor;
@WebServlet("/DoctorServlet")
public class DoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		String Docid=request.getParameter("docid");
		String Docname=request.getParameter("docname");
		String Splid=request.getParameter("splid");
		String Fee=request.getParameter("fee");
	
		Doctorlist doc=new Doctorlist();
		Impdoctor docs=new Impdoctor();
		int id=Integer.parseInt(Docid);
		doc.setDoctorid(id);
		doc.setDoctorname(Docname);
		int spl=Integer.parseInt(Splid);
		doc.setSplzationid(spl);
		int fees=Integer.parseInt(Fee);
		doc.setConsultingfee(fees);
		
		try {
			docs.adddoctor(doc);
			request.setAttribute("infoMessage", "Doctor Added");
		} catch (Dbexception e) {
			request.setAttribute("errorMessage", "Doctor Not Added ");
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("AddDoctor.jsp");
		rd.forward(request, response);
	}		
}

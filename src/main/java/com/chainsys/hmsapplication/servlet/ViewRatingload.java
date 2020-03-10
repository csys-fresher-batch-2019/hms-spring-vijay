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
import com.chainsys.hmsapplication.model.Overallrating;
import com.chainsys.hmsapplication.service.ServiceOverall;


@WebServlet("/ViewRatingload")
public class ViewRatingload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		ServiceOverall imp=new ServiceOverall();
		try {
			ArrayList<Overallrating> list= imp.viewrating();
			
			request.setAttribute("list", list);
			
			RequestDispatcher sp= request.getRequestDispatcher("ViewRating.jsp");
			sp.forward(request, response);
		} catch (Dbexception e) {
			e.printStackTrace();
		}
	
	}

	
}

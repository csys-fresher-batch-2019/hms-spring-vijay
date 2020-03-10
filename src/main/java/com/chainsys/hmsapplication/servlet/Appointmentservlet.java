package com.chainsys.hmsapplication.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Appointmentlist;
import com.chainsys.hmsapplication.randomnumber.Randomnumber;
import com.chainsys.hmsapplication.service.ServiceAppointment;
import com.chainsys.hmsapplication.util.Testconfirm;

@WebServlet("/Appointmentservlet")
public class Appointmentservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String patientIdstr = request.getParameter("patientid");
		String purpose = request.getParameter("purpose");
		String doctorid = request.getParameter("doctorid");
		String Appdate = request.getParameter("app");
		String Apptime = request.getParameter("time");
		String Email = request.getParameter("email");

		Appointmentlist li = new Appointmentlist();

		li.setAppid(Randomnumber.getrandom());
		int patientId = Integer.parseInt(patientIdstr);
		li.setPatientid(patientId);
		li.setPurpose(purpose);
		int doctorId = Integer.parseInt(doctorid);
		li.setDoctorid(doctorId);
		LocalDate l = LocalDate.parse(Appdate);
		li.setAppdate(l);
		li.setApptime(Apptime);
		li.setEmail(Email);

		// Mail obj=new Mail();
		// obj.send(from, password, to, sub, appid, patientid, doctorid, appdate,
		// apptime);
		ServiceAppointment lu = new ServiceAppointment();
		try {
			System.out.println(li);
			lu.addappointment(li);
			Testconfirm.main(li.getAppid(), li.getPatientid(), li.getDoctorid(), li.getAppdate(), li.getApptime(),
					li.getEmail());

		} catch (Dbexception e1) {
			e1.printStackTrace();
		}
		response.sendRedirect("Mailsent.jsp");
	}
}

package com.chainsys.hmsapplication.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Prescriptionlist;
import com.chainsys.hmsapplication.service.ServicePrescription;

@WebServlet("/PrescriptionServlet")
public class PrescriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PrescriptionServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String Patientname = request.getParameter("patientname");
		String Doctorname = request.getParameter("doctorname");
		String comments = request.getParameter("comments");
		String otherfee = request.getParameter("otherfee");
		int ofee = Integer.parseInt(otherfee);

		ServicePrescription imp = new ServicePrescription();
		Prescriptionlist pres = new Prescriptionlist();
		pres.setPatientname(Patientname);
		pres.setDoctorname(Doctorname);
		pres.setComments(comments);
		pres.setTotalamt(ofee);

		int doctorFees = 0;
		try {
			doctorFees = imp.getDoctorFee(Doctorname);
		} catch (Dbexception e1) {

			e1.printStackTrace();
		}
		int finalFees = doctorFees + ofee;
		request.setAttribute("fees", finalFees);
		System.out.println(finalFees);

		try {
			imp.addData(pres);

		} catch (Dbexception e) {
			e.printStackTrace();
		}
		RequestDispatcher d = request.getRequestDispatcher("TotalAmount.jsp");
		d.forward(request, response);
	}
}

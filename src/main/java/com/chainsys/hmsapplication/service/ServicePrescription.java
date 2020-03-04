package com.chainsys.hmsapplication.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.hmsapplication.dao.Interfaceprescription;
import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Prescriptionlist;
@Service
public class ServicePrescription {
	@Autowired
	Interfaceprescription pres;

	public void addData(Prescriptionlist L) throws Dbexception {
		pres.addData(L);
	}

	public ArrayList<Prescriptionlist> viewData() throws Dbexception {
		return pres.viewData();
	}

	public int getDoctorFee(String doctorname) throws Dbexception {
		return pres.getDoctorFee(doctorname);

	}

}

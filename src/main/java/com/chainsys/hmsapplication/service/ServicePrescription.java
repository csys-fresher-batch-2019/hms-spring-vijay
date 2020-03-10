package com.chainsys.hmsapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.hmsapplication.dao.Interfaceprescription;
import com.chainsys.hmsapplication.dao.impl.Impprescription;
import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Prescription;

@Service
public class ServicePrescription {
	@Autowired
	Interfaceprescription pres = new Impprescription();

	public void addData(Prescription L) throws Dbexception {
		pres.addPrescriptionData(L);
	}

	public List<Prescription> viewData() throws Dbexception {
		return pres.viewData();
	}

	public int getDoctorFee(String doctorname) throws Dbexception {
		return pres.getDoctorFee(doctorname);

	}
}

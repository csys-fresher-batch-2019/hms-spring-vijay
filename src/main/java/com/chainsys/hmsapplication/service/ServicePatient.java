package com.chainsys.hmsapplication.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.hmsapplication.dao.InterfacePatients;
import com.chainsys.hmsapplication.dao.impl.ImpPatients;
import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Patientreglist;
@Service
public class ServicePatient {
	@Autowired
	InterfacePatients patient ;
	public void addpatient(Patientreglist p) throws Dbexception {
		patient.addpatient(p);

	}

	public ArrayList<Patientreglist> viewpatient() throws Dbexception {
		return patient.viewpatient();

	}

}

package com.chainsys.hmsapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.hmsapplication.dao.InterfacePatients;
import com.chainsys.hmsapplication.dao.impl.ImpPatients;
import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.PatientRegistration;

@Service
public class ServicePatient {
	@Autowired
	InterfacePatients patient = new ImpPatients();

	public void addpatient(PatientRegistration p) throws Dbexception {
		patient.savePatient(p);

	}

	public List<PatientRegistration> viewpatient() throws Dbexception {
		return patient.viewPatient();

	}
}

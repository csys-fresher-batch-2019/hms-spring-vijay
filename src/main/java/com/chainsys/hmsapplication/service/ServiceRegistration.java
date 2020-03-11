package com.chainsys.hmsapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.hmsapplication.dao.InterfaceRegistration;
import com.chainsys.hmsapplication.dao.impl.ImpRegistration;
import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.PatientRegistration;

@Service
public class ServiceRegistration {
	@Autowired
	InterfaceRegistration patient = new ImpRegistration();

	public void addpatient(PatientRegistration p) throws Dbexception {
		patient.savePatient(p);

	}

	public List<PatientRegistration> viewpatient() throws Dbexception {
		return patient.viewPatient();

	}
}

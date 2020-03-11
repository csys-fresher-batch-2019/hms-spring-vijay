package com.chainsys.hmsapplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chainsys.hmsapplication.dao.RegistrationDao;
import com.chainsys.hmsapplication.dao.impl.RegistrationDaoImpl;
import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.PatientRegistration;

@Service
public class ServiceRegistration {

	RegistrationDao patient = new RegistrationDaoImpl();

	public void appendPatient(PatientRegistration p) throws Dbexception {
		patient.savePatient(p);

	}

	public List<PatientRegistration> viewPatient() throws Dbexception {
		return patient.viewPatient();

	}
}

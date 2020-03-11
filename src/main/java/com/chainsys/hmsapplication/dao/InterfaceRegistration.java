package com.chainsys.hmsapplication.dao;

import java.util.List;

import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.PatientRegistration;

public interface InterfaceRegistration {

	public void savePatient(PatientRegistration p) throws Dbexception;

	public List<PatientRegistration> viewPatient() throws Dbexception;
}

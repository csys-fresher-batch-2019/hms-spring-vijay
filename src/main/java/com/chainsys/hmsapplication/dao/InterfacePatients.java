package com.chainsys.hmsapplication.dao;

import java.util.List;

import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Patientreglist;

public interface InterfacePatients {

	public void savePatient(Patientreglist p) throws Dbexception;

	public List<Patientreglist> viewPatient() throws Dbexception;
}

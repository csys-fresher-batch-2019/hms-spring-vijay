package com.chainsys.hmsapplication.dao;

import java.util.ArrayList;

import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Patientreglist;

public interface InterfacePatients {
	
	public void addpatient(Patientreglist p) throws Dbexception;
	public ArrayList<Patientreglist> viewpatient() throws Dbexception;
}

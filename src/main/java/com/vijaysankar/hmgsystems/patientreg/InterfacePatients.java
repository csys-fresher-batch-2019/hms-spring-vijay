package com.vijaysankar.hmgsystems.patientreg;

import java.util.ArrayList;

import com.vijaysankar.hmgsystems.dbexception.Dbexception;

public interface InterfacePatients {
	
	public void addpatient(Patientreglist p) throws Dbexception;
	public ArrayList<Patientreglist> viewpatient() throws Dbexception;
}

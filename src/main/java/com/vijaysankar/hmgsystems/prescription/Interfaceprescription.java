package com.vijaysankar.hmgsystems.prescription;

import java.util.ArrayList;

import com.vijaysankar.hmgsystems.dbexception.Dbexception;

public interface Interfaceprescription {
	
	public void addData(Prescriptionlist L) throws Dbexception;
	public ArrayList<Prescriptionlist> viewData() throws Dbexception;

}

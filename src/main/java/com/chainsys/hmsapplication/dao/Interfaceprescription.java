package com.chainsys.hmsapplication.dao;

import java.util.ArrayList;

import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Prescriptionlist;

public interface Interfaceprescription {
	
	public void addData(Prescriptionlist L) throws Dbexception;
	public ArrayList<Prescriptionlist> viewData() throws Dbexception;
	public int getDoctorFee(String doctorName) throws Dbexception;

}

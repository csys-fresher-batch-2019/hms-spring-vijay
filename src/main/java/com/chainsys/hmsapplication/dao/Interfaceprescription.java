package com.chainsys.hmsapplication.dao;

import java.util.List;

import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Prescriptionlist;

public interface Interfaceprescription {

	public void addPrescriptionData(Prescriptionlist L) throws Dbexception;

	public List<Prescriptionlist> viewData() throws Dbexception;

	public int getDoctorFee(String doctorName) throws Dbexception;

}

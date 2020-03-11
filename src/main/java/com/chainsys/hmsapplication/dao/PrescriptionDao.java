package com.chainsys.hmsapplication.dao;

import java.util.List;

import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Prescription;

public interface PrescriptionDao {

	public void addPrescriptionData(Prescription L) throws Dbexception;

	public List<Prescription> viewData() throws Dbexception;

	public int getDoctorFee(String doctorName) throws Dbexception;

}

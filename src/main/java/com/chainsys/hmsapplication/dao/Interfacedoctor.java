package com.chainsys.hmsapplication.dao;

import java.util.List;

import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Doctor;

public interface Interfacedoctor {
	public void saveDoctor(Doctor addoc) throws Dbexception;

	public void addOverAllRating(Doctor addoc) throws Dbexception;

	public List<Doctor> viewDoctor() throws Dbexception;

	public List<String> listDoctorName() throws Dbexception;

	public List<Integer> listDoctorId() throws Dbexception;
}

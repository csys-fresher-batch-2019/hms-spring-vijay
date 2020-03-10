package com.chainsys.hmsapplication.dao;

import java.util.List;

import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Doctorlist;

public interface Interfacedoctor {
	public void saveDoctor(Doctorlist addoc) throws Dbexception;

	public void addOverAllRating(Doctorlist addoc) throws Dbexception;

	public List<Doctorlist> viewDoctor() throws Dbexception;

	public List<String> listDoctorName() throws Dbexception;

	public List<Integer> listDoctorId() throws Dbexception;
}

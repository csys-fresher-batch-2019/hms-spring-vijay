package com.chainsys.hmsapplication.dao;

import java.util.List;

import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Specialization;

public interface Interfacespl {
	public void saveSpecialization(Specialization s) throws Dbexception;

	public List<Specialization> viewSpecialization() throws Dbexception;

	public List<Integer> listSpecialization() throws Dbexception;
}

package com.chainsys.hmsapplication.dao;

import java.util.List;

import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Splzationlist;

public interface Interfacespl {
	public void saveSpecialization(Splzationlist s) throws Dbexception;

	public List<Splzationlist> viewSpecialization() throws Dbexception;

	public List<Integer> listSpecialization() throws Dbexception;
}

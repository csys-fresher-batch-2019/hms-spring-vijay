package com.chainsys.hmsapplication.dao;

import java.util.List;

import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Specialization;

public interface SpecializationDao {
	public void saveSpecialization(Specialization s) throws Dbexception;

	public List<Specialization> viewSpecialization() throws Dbexception;

	public List<Integer> findAllSpecialization() throws Dbexception;
}

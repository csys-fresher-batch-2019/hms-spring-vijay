package com.chainsys.hmsapplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chainsys.hmsapplication.dao.SpecializationDao;
import com.chainsys.hmsapplication.dao.impl.SpecializationDaoImpl;
import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Specialization;

@Service
public class ServiceSpecialization {

	SpecializationDao spl = new SpecializationDaoImpl();

	public void appendSpecialization(Specialization s) throws Dbexception {
		spl.saveSpecialization(s);
	}

	public List<Specialization> viewSpecialization() throws Dbexception {
		return spl.viewSpecialization();
	}

	public List<Integer> listSpecialization() throws Dbexception {
		return spl.findAllSpecialization();
	}
}

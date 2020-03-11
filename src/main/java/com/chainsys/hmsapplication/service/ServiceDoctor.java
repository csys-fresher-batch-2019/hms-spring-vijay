package com.chainsys.hmsapplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chainsys.hmsapplication.dao.DoctorDao;
import com.chainsys.hmsapplication.dao.impl.DoctorDaoImpl;
import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Doctor;

@Service
public class ServiceDoctor {


	DoctorDao docs = new DoctorDaoImpl();

	public void appendDoctor(Doctor addoc) throws Dbexception {
		docs.saveDoctor(addoc);

	}

	public List<Doctor> viewDoctor() throws Dbexception {
		return docs.viewDoctor();

	}

	public List<String> findAllDoctorName() throws Dbexception {
		return docs.findAllDoctorNameList();

	}

	public List<Integer> findAllDoctorId() throws Dbexception {
		return docs.findAllDoctorIdList();

	}
}

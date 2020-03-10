package com.chainsys.hmsapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.hmsapplication.dao.Interfacedoctor;
import com.chainsys.hmsapplication.dao.impl.Impdoctor;
import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Doctorlist;

@Service
public class ServiceDoctor {
	@Autowired

	Interfacedoctor docs = new Impdoctor();

	public void adddoctor(Doctorlist addoc) throws Dbexception {
		docs.saveDoctor(addoc);

	}

	public List<Doctorlist> viewdoctor() throws Dbexception {
		return docs.viewDoctor();

	}

	public List<String> doclist() throws Dbexception {
		return docs.listDoctorName();

	}

	public List<Integer> doctorid() throws Dbexception {
		return docs.listDoctorId();

	}
}

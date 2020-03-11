package com.chainsys.hmsapplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chainsys.hmsapplication.dao.Interfacespl;
import com.chainsys.hmsapplication.dao.impl.Impspecialization;
import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Specialization;

@Service
public class ServiceSpecialization {

	Interfacespl spl = new Impspecialization();

	public void addspecialization(Specialization s) throws Dbexception {
		spl.saveSpecialization(s);
	}

	public List<Specialization> viewspl() throws Dbexception {
		return spl.viewSpecialization();
	}

	public List<Integer> getspl() throws Dbexception {
		return spl.listSpecialization();
	}
}

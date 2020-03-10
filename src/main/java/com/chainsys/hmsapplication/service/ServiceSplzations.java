package com.chainsys.hmsapplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chainsys.hmsapplication.dao.Interfacespl;
import com.chainsys.hmsapplication.dao.impl.Impspecialization;
import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Splzationlist;

@Service
public class ServiceSplzations {

	Interfacespl spl = new Impspecialization();

	public void addspecialization(Splzationlist s) throws Dbexception {
		spl.saveSpecialization(s);
	}

	public List<Splzationlist> viewspl() throws Dbexception {
		return spl.viewSpecialization();
	}

	public List<Integer> getspl() throws Dbexception {
		return spl.listSpecialization();
	}
}

package com.chainsys.hmsapplication.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.hmsapplication.dao.Interfacespl;
import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Splzationlist;
@Service
public class ServiceSplzations {
	@Autowired
	Interfacespl spl;

	public void addspecialization(Splzationlist s) throws Dbexception {
		spl.addspecialization(s);
	}

	public ArrayList<Splzationlist> viewspl() throws Dbexception {
		return spl.viewspl();
	}

	public ArrayList<Integer> getspl() throws Dbexception {
		return spl.getspl();
	}

}

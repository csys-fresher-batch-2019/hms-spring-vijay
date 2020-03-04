package com.chainsys.hmsapplication.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.hmsapplication.dao.Interfaceoverallrating;
import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Overallrating;
@Service
public class ServiceOverall {
	@Autowired

	Interfaceoverallrating imp ;

	public void syncrating(int doctorid) throws Dbexception {
		imp.syncrating(doctorid);

	}

	public void add(int doc) throws Dbexception {
		imp.add(doc);
	}

	public ArrayList<Overallrating> viewrating() throws Dbexception {
		return imp.viewrating();
	}

}

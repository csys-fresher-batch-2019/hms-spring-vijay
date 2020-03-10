package com.chainsys.hmsapplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.hmsapplication.dao.Interfaceoverallrating;
import com.chainsys.hmsapplication.dao.impl.Impoverall;
import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.OverallRating;

@Service
public class ServiceOverall {
	@Autowired

	Interfaceoverallrating imp = new Impoverall();

	public void syncrating(int doctorid) throws Dbexception {
		imp.syncRating(doctorid);

	}

	public void add(int doc) throws Dbexception {
		imp.addDoctorId(doc);
	}

	public List<OverallRating> viewrating() throws Dbexception {
		return imp.viewRating();
	}

}

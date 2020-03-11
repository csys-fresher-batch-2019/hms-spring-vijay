package com.chainsys.hmsapplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chainsys.hmsapplication.dao.OverallRatingDao;
import com.chainsys.hmsapplication.dao.impl.OverallDaoImpl;
import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.OverallRating;

@Service
public class ServiceOverall {

	OverallRatingDao imp = new OverallDaoImpl();

	public void syncRating(int doctorid) throws Dbexception {
		imp.calculateRating(doctorid);

	}

	public void appendDoctorId(int doc) throws Dbexception {
		imp.addDoctorId(doc);
	}

	public List<OverallRating> viewRating() throws Dbexception {
		return imp.viewRating();
	}

}

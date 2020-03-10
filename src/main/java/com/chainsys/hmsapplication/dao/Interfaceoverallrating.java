package com.chainsys.hmsapplication.dao;

import java.util.List;

import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.OverallRating;

public interface Interfaceoverallrating {

	public void syncRating(int doctorid) throws Dbexception;

	public void addDoctorId(int doc) throws Dbexception;

	public List<OverallRating> viewRating() throws Dbexception;

}

package com.chainsys.hmsapplication.dao;

import java.util.ArrayList;

import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Overallrating;

public interface Interfaceoverallrating {
	
	public void syncrating(int doctorid) throws Dbexception;
	public void add(int doc) throws Dbexception;
	public ArrayList<Overallrating> viewrating() throws Dbexception;

}

package com.chainsys.hmsapplication.dao;

import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Userrating;

public interface Interfaceadduserrating {
	
	public void addRating(Userrating u) throws Dbexception;

}

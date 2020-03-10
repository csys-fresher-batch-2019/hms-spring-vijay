package com.chainsys.hmsapplication.dao;

import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.UserRating;

public interface Interfaceadduserrating {
	
	public void addRating(UserRating u) throws Dbexception;

}

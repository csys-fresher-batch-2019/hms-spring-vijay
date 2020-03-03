package com.chainsys.hmsapplication.dao;

import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Userrating;

public interface Interfaceadduserrating {
	
	public void addrating(Userrating u) throws Dbexception;

}

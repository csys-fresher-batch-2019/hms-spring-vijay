package com.chainsys.hmsapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.hmsapplication.dao.Interfaceadduserrating;
import com.chainsys.hmsapplication.dao.impl.Impuserrating;
import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Userrating;
@Service
public class ServiceUserRating {
	@Autowired
	Interfaceadduserrating user = new Impuserrating();

	public void addrating(Userrating u) throws Dbexception {
		user.addrating(u);

	}

}

package com.chainsys.hmsapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.hmsapplication.dao.Interfaceadduserrating;
import com.chainsys.hmsapplication.dao.impl.Impuserrating;
import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.UserRating;

@Service
public class ServiceUserRating {
	@Autowired
	Interfaceadduserrating user = new Impuserrating();

	public void addrating(UserRating u) throws Dbexception {
		user.addRating(u);
	}
}

package com.chainsys.hmsapplication.service;

import org.springframework.stereotype.Service;

import com.chainsys.hmsapplication.dao.UserRatingDao;
import com.chainsys.hmsapplication.dao.impl.UserRatingDaoImpl;
import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.UserRating;

@Service
public class ServiceUserRating {

	UserRatingDao user = new UserRatingDaoImpl();

	public void addRating(UserRating u) throws Dbexception {
		user.appendRating(u);
	}
}

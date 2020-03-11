package com.chainsys.hmsapplication.dao;

import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.UserRating;

public interface UserRatingDao {
	
	public void appendRating(UserRating u) throws Dbexception;

}

package com.chainsys.hmsapplication.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.chainsys.hmsapplication.dao.Interfaceadduserrating;
import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Userrating;
import com.chainsys.hmsapplication.util.*; 
@Repository
public class Impuserrating implements Interfaceadduserrating {

	private static final Logger LOGGER = LoggerFactory.getLogger(Impuserrating.class);

	public void addrating(Userrating adrating) throws Dbexception {

		String sql = "insert into rating values(?,?,?)";
		try (Connection con = connections.TestConnections(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, adrating.getPatient_id());
			pst.setInt(2, adrating.getDoctor_id());
			pst.setFloat(3, adrating.getRating());
			int row = pst.executeUpdate();
			LOGGER.info("row");
			Impoverall obj = new Impoverall();
			obj.syncrating(adrating.getDoctor_id());

		} catch (Exception e) {
			throw new Dbexception("Insertion into Rating failed");
		}
	}
}

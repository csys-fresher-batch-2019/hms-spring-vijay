package com.chainsys.hmsapplication.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.chainsys.hmsapplication.dao.Interfaceadduserrating;
import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.UserRating;
import com.chainsys.hmsapplication.util.*;

@Repository
public class Impuserrating implements Interfaceadduserrating {

	public void addRating(UserRating adrating) throws Dbexception {

		String sql = "insert into rating values(?,?,?)";
		try (Connection con = connections.TestConnections(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, adrating.getPatientId());
			pst.setInt(2, adrating.getDoctorId());
			pst.setFloat(3, adrating.getRating());
			pst.executeUpdate();
			Impoverall obj = new Impoverall();
			obj.syncRating(adrating.getDoctorId());

		} catch (SQLException e) {
			throw new Dbexception("Insertion into Rating failed");
		}
	}
}

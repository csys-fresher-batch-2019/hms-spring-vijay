package com.chainsys.hmsapplication.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.chainsys.hmsapplication.dao.Interfaceoverallrating;
import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.OverallRating;
import com.chainsys.hmsapplication.util.connections;

@Repository
public class Impoverall implements Interfaceoverallrating {

	public void syncRating(int doctorid) throws Dbexception {
		String sql1 = "select avg(rating) as avg from rating where doctor_id=?";
		try (Connection con = connections.TestConnections(); PreparedStatement pst = con.prepareStatement(sql1);) {
			pst.setInt(1, doctorid);
			try (ResultSet rs = pst.executeQuery();) {
				rs.next();
				float average = rs.getFloat("avg");
				updateOverallRating(doctorid, average);
			}
		} catch (SQLException e) {
			throw new Dbexception("Updation of doctor_id in overallrating failed");
		}
	}

	public void updateOverallRating(int doctorid, float average) throws Dbexception {
		String sql = "update overallrating set rating =? where doctor_id=?";
		try (Connection con = connections.TestConnections(); PreparedStatement pst1 = con.prepareStatement(sql);) {
			pst1.setFloat(1, average);
			pst1.setInt(2, doctorid);
			pst1.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Dbexception("updation of rating in overallrating failed");
		}
	}

	public void addDoctorId(int doc) throws Dbexception {

		String sql = "insert into overallrating(doctor_id) values(?)";
		try (Connection con = connections.TestConnections(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, doc);
			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new Dbexception("inserting doctor_id in overallrating failed");
		}
	}
	
	public List<OverallRating> viewRating() throws Dbexception {
		String sql = "select * from overallrating ";
		ArrayList<OverallRating> obj = new ArrayList<>();
		try (Connection con = connections.TestConnections(); Statement stmt = con.createStatement();) {
			try (ResultSet rs = stmt.executeQuery(sql);) {
				while (rs.next()) {
					OverallRating o = new OverallRating();
					o.setDoctorId(rs.getInt("doctor_id"));
					o.setRating(rs.getInt("rating"));
					obj.add(o);
				}
				return obj;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Dbexception("selection of overallrating failed");
		}
	}
}
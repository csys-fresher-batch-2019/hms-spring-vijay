package com.chainsys.hmsapplication.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.chainsys.hmsapplication.dao.Interfacespl;
import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Specialization;
import com.chainsys.hmsapplication.util.ConnectionUtil;

@Repository
public class Impspecialization implements Interfacespl {

	public void saveSpecialization(Specialization adspl) throws Dbexception {

		String sql = "insert into splzations values(?,?)";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, adspl.getSpecializationId());
			pst.setString(2, adspl.getSpecializationName());
			pst.executeUpdate();

		}

		catch (SQLException e) {
			throw new Dbexception("Insertion into specialization failed");
		}
	}

	public List<Specialization> viewSpecialization() throws Dbexception {

		String sql = "select * from splzations";
		List<Specialization> s1 = new ArrayList<Specialization>();
		try (Connection con = ConnectionUtil.getConnection(); Statement stmt = con.createStatement();) {
			try (ResultSet rs = stmt.executeQuery(sql);) {
				while (rs.next()) {
					Specialization spllist = new Specialization();
					spllist.setSpecializationId(rs.getInt("splzation_id"));
					spllist.setSpecializationName(rs.getString("splzation_name"));
					s1.add(spllist);
				}
			}
			return s1;
		} catch (Exception e) {
			throw new Dbexception("selection from specializations failed");
		}
	}

	public ArrayList<Integer> listSpecialization() throws Dbexception {
		String sql = "select splzation_id from splzations";
		ArrayList<Integer> spl = new ArrayList<>();
		try (Connection con = ConnectionUtil.getConnection(); Statement stmt = con.createStatement();) {
			try (ResultSet rs = stmt.executeQuery(sql);) {
				while (rs.next()) {
					int id = rs.getInt("splzation_id");
					spl.add(id);
				}
			}
			return spl;
		} catch (Exception e) {
			throw new Dbexception("displaying list of splzations failed");
		}
	}
}

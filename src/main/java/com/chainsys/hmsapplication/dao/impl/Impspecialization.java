package com.chainsys.hmsapplication.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.chainsys.hmsapplication.dao.Interfacespl;
import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Splzationlist;
import com.vijaysankar.hmgsystems.patientreg.connections;

@Repository
public class Impspecialization implements Interfacespl {

	private static final Logger LOGGER = LoggerFactory.getLogger(Impspecialization.class);

	public void addspecialization(Splzationlist adspl) throws Dbexception {

		String sql = "insert into splzations values(?,?)";
		try (Connection con = connections.TestConnections(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, adspl.getSplzationid());
			pst.setString(2, adspl.getSplzationname());
			int rows = pst.executeUpdate();
			LOGGER.info("rows");
		}

		catch (Exception e) {
			throw new Dbexception("Insertion into specialization failed");
		}
	}

	public ArrayList<Splzationlist> viewspl() throws Dbexception {

		String sql = "select * from splzations";
		ArrayList<Splzationlist> s1 = new ArrayList<Splzationlist>();
		try (Connection con = connections.TestConnections(); Statement stmt = con.createStatement();) {
			try (ResultSet rs = stmt.executeQuery(sql);) {
				while (rs.next()) {
					Splzationlist splli = new Splzationlist();
					splli.setSplzationid(rs.getInt("splzation_id"));
					splli.setSplzationname(rs.getString("splzation_name"));
					s1.add(splli);
				}
			}
			return s1;
		} catch (Exception e) {
			throw new Dbexception("selection from specializations failed");
		}
	}

	public ArrayList<Integer> getspl() throws Dbexception {
		String sql = "select splzation_id from splzations";
		ArrayList<Integer> spl = new ArrayList<>();
		try (Connection con = connections.TestConnections(); Statement stmt = con.createStatement();) {
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

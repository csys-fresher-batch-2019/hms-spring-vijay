package com.chainsys.hmsapplication.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.chainsys.hmsapplication.dao.Interfacedoctor;
import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Doctorlist;
import com.chainsys.hmsapplication.util.connections;

@Repository
public class Impdoctor implements Interfacedoctor {

	public void saveDoctor(Doctorlist addoc) throws Dbexception {
		String sql = "insert into doctorlist values(?,?,?,?)";
		try (Connection con = connections.TestConnections(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, addoc.getDoctorid());
			pst.setString(2, addoc.getDoctorname());
			pst.setInt(3, addoc.getSplzationid());
			pst.setInt(4, addoc.getConsultingfee());
			pst.executeUpdate();

			addOverAllRating(addoc);
		} catch (SQLException e) {
			throw new Dbexception("insertion doctorlist failed");
		}
	}

	public void addOverAllRating(Doctorlist addoc) throws Dbexception {
		String sql1 = "insert into overallrating(doctor_id) values(?)";
		try (Connection con = connections.TestConnections(); PreparedStatement pst1 = con.prepareStatement(sql1);) {
			pst1.setInt(1, addoc.getDoctorid());

			pst1.executeUpdate();

		} catch (SQLException e) {
			throw new Dbexception("insertion of doctor into overallrating failed");
		}
	}

	public ArrayList<Doctorlist> viewDoctor() throws Dbexception {
		String sql = "select * from doctorlist";
		ArrayList<Doctorlist> s1 = new ArrayList<Doctorlist>();
		try (Connection con = connections.TestConnections(); Statement stmt = con.createStatement();) {
			try (ResultSet rs = stmt.executeQuery(sql);) {
				while (rs.next()) {
					Doctorlist docli = new Doctorlist();
					docli.setDoctorid(rs.getInt("doctor_id"));
					docli.setDoctorname(rs.getString("doctor_name"));
					docli.setSplzationid(rs.getInt("splzation_id"));
					docli.setConsultingfee(rs.getInt("consultingfee"));
					s1.add(docli);
				}
			}
			return s1;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Dbexception("selection doctorlist failed");
		}
	}

	public ArrayList<String> listDoctorName() throws Dbexception {
		String sql = "select distinct doctor_name from doctorlist ";
		ArrayList<String> doctorlist = new ArrayList<>();
		try (Connection con = connections.TestConnections(); Statement stmt = con.createStatement();) {
			try (ResultSet rs = stmt.executeQuery(sql);) {
				while (rs.next()) {

					String docs = rs.getString("doctor_name");
					doctorlist.add(docs);
				}
			}
			return doctorlist;
		} catch (SQLException e) {
			throw new Dbexception("Selection of distinct doctorlist failed");
		}
	}

	public List<Integer> listDoctorId() throws Dbexception {
		String sql = "select distinct doctor_id from doctorlist ";
		ArrayList<Integer> docid = new ArrayList<>();
		try (Connection con = connections.TestConnections(); Statement stmt = con.createStatement();) {
			try (ResultSet rs = stmt.executeQuery(sql);) {
				while (rs.next()) {

					Integer docs = rs.getInt("doctor_id");
					docid.add(docs);
				}
			}
			return docid;
		} catch (SQLException e) {
			throw new Dbexception("Selection of distinct doctorlist failed", e);
		}
	}
}
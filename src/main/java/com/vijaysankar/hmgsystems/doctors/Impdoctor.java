package com.vijaysankar.hmgsystems.doctors;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.vijaysankar.hmgsystems.dbexception.Dbexception;
import com.vijaysankar.hmgsystems.patientreg.connections;
import com.vijaysankar.hmgsystems.util.Logger;

public class Impdoctor {
	Logger logger = Logger.getInstance();

	public void adddoctor(Doctorlist addoc) throws Dbexception {
		String sql = "insert into doctorlist values(?,?,?,?)";
		try (Connection con = connections.TestConnections(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, addoc.getDoctorid());
			pst.setString(2, addoc.getDoctorname());
			pst.setInt(3, addoc.getSplzationid());
			pst.setInt(4, addoc.getConsultingfee());
			int rows = pst.executeUpdate();
			logger.info(rows);
			System.out.println(addoc.getDoctorid());
			String sql1 = "insert into overallrating(doctor_id) values(?)";

			try (PreparedStatement pst1 = con.prepareStatement(sql1);) {

				pst1.setInt(1, addoc.getDoctorid());

				int row = pst1.executeUpdate();
				logger.info(row);
			}
		} catch (Exception e) {
			throw new Dbexception("insertion doctorlist failed");
		}
	}

	public ArrayList<Doctorlist> viewdoctor() throws Dbexception {
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
		} catch (Exception e) {
			throw new Dbexception("selection doctorlist failed");
		}
	}

	public ArrayList<String> doclist() throws Dbexception {
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
		} catch (Exception e) {
			throw new Dbexception("Selection of distinct doctorlist failed");
		}
	}

public ArrayList<Integer> doctorid() throws Dbexception {
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
	} catch (Exception e) {
		throw new Dbexception("Selection of distinct doctorlist failed");
	}
}
}
	


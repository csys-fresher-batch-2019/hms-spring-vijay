package com.chainsys.hmsapplication.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.chainsys.hmsapplication.dao.Interfaceapp;
import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Appointmentlist;
import com.chainsys.hmsapplication.util.*;

@Repository
public class Impappointment implements Interfaceapp {

	private static final Logger LOGGER = LoggerFactory.getLogger(Impappointment.class);

	public void addappointment(Appointmentlist adapp) throws Dbexception {

		String sql = "insert into appointment (app_id,patient_id,purpose,doctor_id,app_date,app_time) values(?,?,?,?,?,?)";
		try (Connection con = connections.TestConnections(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, adapp.getAppid());
			pst.setInt(2, adapp.getPatientid());
			pst.setString(3, adapp.getPurpose());
			pst.setInt(4, adapp.getDoctorid());
			pst.setDate(5, Date.valueOf(adapp.getAppdate()));
			pst.setString(6, adapp.getApptime());
			int rows = pst.executeUpdate();
			LOGGER.info("rows");
		} catch (Exception e) {
			throw new Dbexception("Appointment insertion failed", e);
		}
	}

	public void updateappointment(int pid) throws Dbexception {
		String sql = "update appointment set status='approved' where app_id= ?";
		try (Connection con = connections.TestConnections(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, pid);
			int rows = pst.executeUpdate();
			LOGGER.info("rows");
		} catch (Exception e) {
			throw new Dbexception("Appointment approve status failed");
		}
	}

	public void updatevisited(int aid) throws Dbexception {

		String sql1 = "update appointment set visited = 'yes' where app_id=?";
		try (Connection con = connections.TestConnections(); PreparedStatement pst = con.prepareStatement(sql1);) {
			pst.setInt(1, aid);
			int rows = pst.executeUpdate();
			LOGGER.info("rows");
		} catch (Exception e) {
			throw new Dbexception("Appointment visited status failed");
		}
	}

	public ArrayList<Appointmentlist> viewapp() throws Dbexception {

		String sql = "select * from appointment order by app_date desc";
		ArrayList<Appointmentlist> obj = new ArrayList<Appointmentlist>();
		try (Connection con = connections.TestConnections(); Statement stmt = con.createStatement();) {
			try (ResultSet rs = stmt.executeQuery(sql);) {
				while (rs.next()) {
					Appointmentlist h = new Appointmentlist();
					h.setAppid(rs.getInt("app_id"));
					h.setPatientid(rs.getInt("patient_id"));
					h.setPurpose(rs.getString("purpose"));
					h.setDoctorid(rs.getInt("doctor_id"));
					Date st = rs.getDate("app_date");
					h.setAppdate(st.toLocalDate());
					h.setApptime(rs.getString("app_time"));
					h.setStatus(rs.getString("status"));
					h.setVisited(rs.getString("visited"));
					obj.add(h);
				}
			}
			return obj;
		} catch (Exception e) {
			throw new Dbexception("selection failed");
		}
	}

	public ArrayList<Appointmentlist> viewpendingapp() throws Dbexception {

		String sql = "select * from appointment where status='pending' order by app_date desc";
		ArrayList<Appointmentlist> obj = new ArrayList<Appointmentlist>();
		try (Connection con = connections.TestConnections(); Statement stmt = con.createStatement();) {
			try (ResultSet rs = stmt.executeQuery(sql);) {
				while (rs.next()) {
					Appointmentlist h = new Appointmentlist();
					h.setAppid(rs.getInt("app_id"));
					h.setPatientid(rs.getInt("patient_id"));
					h.setPurpose(rs.getString("purpose"));
					h.setDoctorid(rs.getInt("doctor_id"));
					Date st = rs.getDate("app_date");
					h.setAppdate(st.toLocalDate());
					h.setApptime(rs.getString("app_time"));
					h.setStatus(rs.getString("status"));
					obj.add(h);
				}
			}
			return obj;
		} catch (Exception e) {
			throw new Dbexception("selection failed");
		}
	}

	public ArrayList<Appointmentlist> viewstatus() throws Dbexception {

		String sql = "select * from appointment where status='approved'order by app_date desc";
		ArrayList<Appointmentlist> obj = new ArrayList<Appointmentlist>();
		try (Connection con = connections.TestConnections(); Statement stmt = con.createStatement();) {
			try (ResultSet rs = stmt.executeQuery(sql);) {
				while (rs.next()) {
					Appointmentlist h = new Appointmentlist();
					h.setAppid(rs.getInt("app_id"));
					h.setPatientid(rs.getInt("patient_id"));
					h.setPurpose(rs.getString("purpose"));
					h.setDoctorid(rs.getInt("doctor_id"));
					Date st = rs.getDate("app_date");
					h.setAppdate(st.toLocalDate());
					h.setApptime(rs.getString("app_time"));
					h.setVisited(rs.getString("visited"));
					obj.add(h);
				}
			}
			return obj;
		} catch (Exception e) {
			throw new Dbexception("selection failed");
		}
	}
}
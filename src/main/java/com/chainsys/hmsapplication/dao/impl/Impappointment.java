package com.chainsys.hmsapplication.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.chainsys.hmsapplication.dao.Interfaceapp;
import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Appointmentlist;
import com.chainsys.hmsapplication.util.connections;

@Repository
public class Impappointment implements Interfaceapp {

	public void saveAppointment(Appointmentlist adapp) throws Dbexception {

		String sql = "insert into appointment (app_id,patient_id,purpose,doctor_id,app_date,app_time) values(?,?,?,?,?,?)";
		try (Connection con = connections.TestConnections(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, adapp.getAppid());
			pst.setInt(2, adapp.getPatientid());
			pst.setString(3, adapp.getPurpose());
			pst.setInt(4, adapp.getDoctorid());
			pst.setDate(5, Date.valueOf(adapp.getAppdate()));
			pst.setString(6, adapp.getApptime());
			pst.executeUpdate();

		} catch (SQLException e) {
			throw new Dbexception("Appointment insertion failed", e);
		}
	}

	public void updateAppointment(int pid) throws Dbexception {
		String sql = "update appointment set status='approved' where app_id= ?";
		try (Connection con = connections.TestConnections(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, pid);
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new Dbexception("Appointment approve status failed");
		}
	}

	public void updateVisited(int aid) throws Dbexception {

		String sql1 = "update appointment set visited = 'yes' where app_id=?";
		try (Connection con = connections.TestConnections(); PreparedStatement pst = con.prepareStatement(sql1);) {
			pst.setInt(1, aid);
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new Dbexception("Appointment visited status failed");
		}
	}

	public List<Appointmentlist> viewAppointment() throws Dbexception {

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
		} catch (SQLException e) {
			throw new Dbexception("selection failed");
		}
	}

	public List<Appointmentlist> viewPendingAppointment() throws Dbexception {

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
		} catch (SQLException e) {
			throw new Dbexception("selection failed");
		}
	}

	public List<Appointmentlist> viewStatus() throws Dbexception {

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
		} catch (SQLException e) {
			throw new Dbexception("selection failed");
		}
	}
}
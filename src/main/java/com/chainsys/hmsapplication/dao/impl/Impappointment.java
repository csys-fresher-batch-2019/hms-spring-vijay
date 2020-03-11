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
import com.chainsys.hmsapplication.model.Appointment;
import com.chainsys.hmsapplication.util.ConnectionUtil;

@Repository
public class Impappointment implements Interfaceapp {

	public void saveAppointment(Appointment adapp) throws Dbexception {

		String sql = "insert into appointment (app_id,patient_id,purpose,doctor_id,app_date,app_time) values(?,?,?,?,?,?)";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, adapp.getAppointmentId());
			pst.setInt(2, adapp.getPatientId());
			pst.setString(3, adapp.getPurpose());
			pst.setInt(4, adapp.getDoctorId());
			pst.setDate(5, Date.valueOf(adapp.getAppointmentDate()));
			pst.setString(6, adapp.getAppointmentTime());
			pst.executeUpdate();

		} catch (SQLException e) {
			throw new Dbexception("Appointment insertion failed", e);
		}
	}

	public void updateAppointment(int pid) throws Dbexception {
		String sql = "update appointment set status='approved' where app_id= ?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, pid);
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new Dbexception("Appointment approve status failed");
		}
	}

	public void updateVisited(int aid) throws Dbexception {

		String sql1 = "update appointment set visited = 'yes' where app_id=?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql1);) {
			pst.setInt(1, aid);
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new Dbexception("Appointment visited status failed");
		}
	}

	public List<Appointment> viewAppointment() throws Dbexception {

		String sql = "select * from appointment order by app_date desc";
		ArrayList<Appointment> obj = new ArrayList<Appointment>();
		try (Connection con = ConnectionUtil.getConnection(); Statement stmt = con.createStatement();) {
			try (ResultSet rs = stmt.executeQuery(sql);) {
				while (rs.next()) {
					Appointment h = new Appointment();
					h.setAppointmentId(rs.getInt("app_id"));
					h.setPatientId(rs.getInt("patient_id"));
					h.setPurpose(rs.getString("purpose"));
					h.setDoctorId(rs.getInt("doctor_id"));
					Date st = rs.getDate("app_date");
					h.setAppointmentDate(st.toLocalDate());
					h.setAppointmentTime(rs.getString("app_time"));
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

	public List<Appointment> viewPendingAppointment() throws Dbexception {

		String sql = "select * from appointment where status='pending' order by app_date desc";
		ArrayList<Appointment> obj = new ArrayList<Appointment>();
		try (Connection con = ConnectionUtil.getConnection(); Statement stmt = con.createStatement();) {
			try (ResultSet rs = stmt.executeQuery(sql);) {
				while (rs.next()) {
					Appointment h = new Appointment();
					h.setAppointmentId(rs.getInt("app_id"));
					h.setPatientId(rs.getInt("patient_id"));
					h.setPurpose(rs.getString("purpose"));
					h.setDoctorId(rs.getInt("doctor_id"));
					Date st = rs.getDate("app_date");
					h.setAppointmentDate(st.toLocalDate());
					h.setAppointmentTime(rs.getString("app_time"));
					h.setStatus(rs.getString("status"));
					obj.add(h);
				}
			}
			return obj;
		} catch (SQLException e) {
			throw new Dbexception("selection failed");
		}
	}

	public List<Appointment> viewStatus() throws Dbexception {

		String sql = "select * from appointment where status='approved'order by app_date desc";
		ArrayList<Appointment> obj = new ArrayList<Appointment>();
		try (Connection con = ConnectionUtil.getConnection(); Statement stmt = con.createStatement();) {
			try (ResultSet rs = stmt.executeQuery(sql);) {
				while (rs.next()) {
					Appointment h = new Appointment();
					h.setAppointmentId(rs.getInt("app_id"));
					h.setPatientId(rs.getInt("patient_id"));
					h.setPurpose(rs.getString("purpose"));
					h.setDoctorId(rs.getInt("doctor_id"));
					Date st = rs.getDate("app_date");
					h.setAppointmentDate(st.toLocalDate());
					h.setAppointmentTime(rs.getString("app_time"));
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
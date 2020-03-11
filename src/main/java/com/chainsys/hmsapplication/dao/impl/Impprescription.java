package com.chainsys.hmsapplication.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.chainsys.hmsapplication.dao.Interfaceprescription;
import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Prescription;
import com.chainsys.hmsapplication.util.ConnectionUtil;

@Repository
public class Impprescription implements Interfaceprescription {

	public int getDoctorFee(String doctorName) throws Dbexception {
		int fees = 0;
		String sql1 = "select consultingfee from doctorlist where doctor_name=?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst1 = con.prepareStatement(sql1);) {
			pst1.setString(1, doctorName);
			try (ResultSet rs = pst1.executeQuery();) {
				if (rs.next()) {
					fees = rs.getInt("consultingfee");
				}
			}

		} catch (SQLException e) {
			throw new Dbexception("selection of particular doctor failed");
		}
		return fees;
	}

	public void addPrescriptionData(Prescription adpres) throws Dbexception {
		int fee = 0;
		String sql = "insert into prescription(prescription_id,patient_name,doctorname,comments,total_amt)values(prescription_id.nextval,?,?,?,?)";

		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, adpres.getPatientName());
			pst.setString(2, adpres.getDoctorName());
			pst.setString(3, adpres.getComments());
			String sql1 = "select consultingfee from doctorlist where doctor_name=?";
			try (PreparedStatement pst1 = con.prepareStatement(sql1);) {
				pst1.setString(1, adpres.getDoctorName());
				try (ResultSet rs = pst1.executeQuery();) {
					if (rs.next()) {
						fee = rs.getInt("consultingfee");
					}
					int total = adpres.getTotalAmt() + fee;
					pst.setInt(4, total);
					pst.executeUpdate();

				}
			}
		} catch (SQLException e) {
			throw new Dbexception("inserting values into prescription failed");
		}
	}

	public ArrayList<Prescription> viewData() throws Dbexception {

		String sql = "select * from prescription ";
		ArrayList<Prescription> p = new ArrayList<Prescription>();
		try (Connection con = ConnectionUtil.getConnection(); Statement stmt = con.createStatement();) {
			try (ResultSet rs = stmt.executeQuery(sql);) {
				while (rs.next()) {
					Prescription presli = new Prescription();
					presli.setPrescriptionId(rs.getInt("prescription_id"));
					presli.setPatientName(rs.getString("patient_name"));
					presli.setDoctorName(rs.getString("doctorname"));
					presli.setComments(rs.getString("comments"));
					presli.setTotalAmt(rs.getInt("total_amt"));
					p.add(presli);
				}
				return p;
			}
		} catch (SQLException e) {
			throw new Dbexception("selection from prescription failed");
		}
	}
}

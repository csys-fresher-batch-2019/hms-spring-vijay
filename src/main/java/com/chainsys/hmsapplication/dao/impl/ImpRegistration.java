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

import com.chainsys.hmsapplication.dao.InterfaceRegistration;
import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.PatientRegistration;
import com.chainsys.hmsapplication.util.ConnectionUtil;

@Repository
public class ImpRegistration implements InterfaceRegistration {

	public void savePatient(PatientRegistration adpatreg) throws Dbexception {
		String sql = "insert into patientReg(patient_id,patientname,adharcardno,dob,gender,phoneno,patientreg_date)values(patient_id.nextval,?,?,?,?,?,sysdate)";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setString(1, adpatreg.getPatientName());
			pst.setLong(2, adpatreg.getAdharNo());
			java.sql.Date dat = java.sql.Date.valueOf(adpatreg.getDob());
			pst.setDate(3, dat);
			pst.setString(4, adpatreg.getGender());
			pst.setLong(5, adpatreg.getPhoneNo());
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new Dbexception("Insertion into patient Registration failed");
		}
	}

	public List<PatientRegistration> viewPatient() throws Dbexception {
		String sql = "select * from patientReg";
		ArrayList<PatientRegistration> obj = new ArrayList<PatientRegistration>();
		try (Connection con = ConnectionUtil.getConnection(); Statement stmt = con.createStatement();) {
			try (ResultSet rs = stmt.executeQuery(sql);) {
				while (rs.next()) {
					PatientRegistration p2 = new PatientRegistration();
					p2.setPatientId(rs.getInt("patient_id"));
					p2.setPatientName(rs.getString("patientname"));
					p2.setAdharNo(rs.getLong("adharcardno"));
					Date st = rs.getDate("dob");
					if (st != null) {
						p2.setDob(st.toLocalDate());
					}
					p2.setGender(rs.getString("gender"));
					p2.setPhoneNo(rs.getLong("phoneno"));
					p2.setRegistrationDate(rs.getDate("patientReg_date"));
					obj.add(p2);
				}
			}
			return obj;
		} catch (SQLException e) {
			throw new Dbexception("Selection from patient Registration failed");
		}
	}
}
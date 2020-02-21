package com.vijaysankar.hmgsystems.patientreg;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.vijaysankar.hmgsystems.dbexception.Dbexception;
import com.vijaysankar.hmgsystems.util.Logger;
public class ImpPatients {
		
	Logger logger=Logger.getInstance();

	public void addpatient(Patientreglist adpatreg) throws Dbexception{
		String sql = "insert into patientReg(patient_id,patientname,adharcardno,dob,gender,phoneno,patientreg_date)values(patient_id.nextval,?,?,?,?,?,sysdate)";
		try(Connection con = connections.TestConnections();
		PreparedStatement pst= con.prepareStatement(sql);)
		{
		pst.setString(1,adpatreg.getPatientname());	
		pst.setLong(2,adpatreg.getAdharno() );
		java.sql.Date dat = java.sql.Date.valueOf(adpatreg.getDob());
		pst.setDate(3,dat);
		pst.setString(4,adpatreg.getGender() );	
		pst.setLong(5,adpatreg.getPhoneno() );
		int rows= pst.executeUpdate();
		logger.info(rows);
	}catch(Exception e) {
		throw new Dbexception("Insertion into patient Registration failed");
	}
	}
	public ArrayList<Patientreglist> viewpatient() throws Dbexception{
		String sql = "select * from patientReg";
		ArrayList<Patientreglist> obj=new ArrayList<Patientreglist>();
		try(Connection con = connections.TestConnections();	
		Statement stmt=con.createStatement();)
		{
		try(ResultSet rs=stmt.executeQuery(sql);)
		{
		while(rs.next()) {
			Patientreglist p2= new Patientreglist();
			p2.setPatientId(rs.getInt("patient_id"));
			p2.setPatientname(rs.getString("patientname"));
			p2.setAdharno(rs.getLong("adharcardno"));
			Date st=rs.getDate("dob");
			if (st != null) {
			p2.setDob(st.toLocalDate());
			}
			p2.setGender(rs.getString("gender"));
			p2.setPhoneno(rs.getLong("phoneno"));
			p2.setRegdate(rs.getDate("patientReg_date"));
			obj.add(p2);	
			}
		}
		return obj;	
		}catch(Exception e) {
			throw new Dbexception("Selection from patient Registration failed");
		}
		}
		}
package com.vijaysankar.hmgsystems.prescription;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.vijaysankar.hmgsystems.dbexception.Dbexception;
import com.vijaysankar.hmgsystems.patientreg.connections;
import com.vijaysankar.hmgsystems.util.Logger;

public class Impprescription {
		
	Logger logger=Logger.getInstance();
	
	public int getDoctorFee(String doctorName) throws Dbexception {
		int fees = 0;
		String sql1 = "select consultingfee from doctorlist where doctor_name=?";
		try(Connection con = connections.TestConnections();
			PreparedStatement pst1 = con.prepareStatement(sql1);)
		{
		pst1.setString(1, doctorName);
		try(ResultSet rs = pst1.executeQuery();)
		{
		if (rs.next()) {
			fees = rs.getInt("consultingfee");
		}
		}
		
		}catch(Exception e) {
			throw new Dbexception("selection of particular doctor failed");
		}	
		return fees;
	}
		
	
	

	public void addData(Prescriptionlist adpres) throws Dbexception {
		int fee = 0;
		String sql = "insert into prescription(prescription_id,patient_name,doctorname,comments,total_amt)values(prescription_id.nextval,?,?,?,?)";

		try(Connection con = connections.TestConnections();
		PreparedStatement pst = con.prepareStatement(sql);)
		{
		pst.setString(1, adpres.getPatientname());
		pst.setString(2, adpres.getDoctorname());
		pst.setString(3, adpres.getComments());
		String sql1 = "select consultingfee from doctorlist where doctor_name=?";
		try(PreparedStatement pst1 = con.prepareStatement(sql1);)
		{
		pst1.setString(1, adpres.getDoctorname());
		try(ResultSet rs = pst1.executeQuery();)
		{
		if (rs.next()) {
			fee = rs.getInt("consultingfee");
		}
		int total = adpres.getTotalamt() + fee;
		pst.setInt(4, total);
		int rows = pst.executeUpdate();
		logger.info(rows);
		}
		}
		}catch(Exception e) {
			throw new Dbexception("inserting values into prescription failed");
		}	
	}
	public ArrayList<Prescriptionlist> viewData() throws Dbexception {
		
		String sql = "select * from prescription ";
		ArrayList<Prescriptionlist> p = new ArrayList<Prescriptionlist>();
		try(Connection con = connections.TestConnections();
		Statement stmt = con.createStatement();)
		{
		try(ResultSet rs = stmt.executeQuery(sql);)
		{
		while (rs.next()) {
			Prescriptionlist presli = new Prescriptionlist();
			presli.setPresid(rs.getInt("prescription_id"));
			presli.setPatientname(rs.getString("patient_name"));
			presli.setDoctorname(rs.getString("doctorname"));
			presli.setComments(rs.getString("comments"));
			presli.setTotalamt(rs.getInt("total_amt"));
			p.add(presli);
		}
		return p;
		}
		}catch(Exception e) {
		throw new Dbexception("selection from prescription failed");
		}
		}
		}

		



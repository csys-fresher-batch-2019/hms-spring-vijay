package com.chainsys.hmsapplication.model;

import java.sql.Date;
import java.time.LocalDate;

public class Patientreglist {
	private int patientId;
	private String patientname;
	private long adharno;
	private LocalDate dob; 
	private String gender;
	private long phoneno;
	private Date regdate;
	public String toString() {
		return "Patientreglist [patientId=" + getPatientId() + ", patientname=" + getPatientname() + ", adharno=" + getAdharno()
				+ ", dob=" + getDob() + ", gender=" + getGender() + ", phoneno=" + getPhoneno() + ", regDate=" + getRegdate() + "]";
	}
	public String getPatientname() {
		return patientname;
	}
	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}
	public long getAdharno() {
		return adharno;
	}
	public void setAdharno(long adharno) {
		this.adharno = adharno;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	

}

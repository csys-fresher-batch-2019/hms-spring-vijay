package com.chainsys.hmsapplication.model;

import java.sql.Date;
import java.time.LocalDate;

public class PatientRegistration {
	private int patientId;
	private String patientName;
	private long adharNo;
	private LocalDate dob; 
	private String gender;
	private long phoneNo;
	private Date registrationDate;
	public String toString() {
		return "Patientreglist [patientId=" + getPatientId() + ", patientname=" + getPatientName() + ", adharno=" + getAdharNo()
				+ ", dob=" + getDob() + ", gender=" + getGender() + ", phoneno=" + getPhoneNo() + ", regDate=" + getRegistrationDate() + "]";
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public long getAdharNo() {
		return adharNo;
	}
	public void setAdharNo(long adharNo) {
		this.adharNo = adharNo;
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
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	

}

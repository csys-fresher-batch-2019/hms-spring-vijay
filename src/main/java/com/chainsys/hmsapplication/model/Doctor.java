package com.chainsys.hmsapplication.model;

public class Doctor {
	@Override
	public String toString() {
		return "Doctorlist [doctorid=" + doctorId + ", doctorname=" + doctorName + ", splzationid=" + specializationId
				+ ", consultingfee=" + consultationFee + "]";
	}
	private int doctorId;
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorid) {
		this.doctorId = doctorid;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorname) {
		this.doctorName = doctorname;
	}
	public int getSpecializationId() {
		return specializationId;
	}
	public void setSpecializationId(int splzationid) {
		this.specializationId = splzationid;
	}
	public int getConsultationFee() {
		return consultationFee;
	}
	public void setConsultationFee(int consultingfee) {
		this.consultationFee = consultingfee;
	}
	private String doctorName;
	private int specializationId;
	private int consultationFee;
			
}

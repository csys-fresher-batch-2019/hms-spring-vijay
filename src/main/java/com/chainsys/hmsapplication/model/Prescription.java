package com.chainsys.hmsapplication.model;

public class Prescription {
	private int prescriptionId;
	public int getPrescriptionId() {
		return prescriptionId;
	}
	public void setPrescriptionId(int prescriptionId) {
		this.prescriptionId = prescriptionId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public int getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(int totalAmt) {
		this.totalAmt = totalAmt;
	}
	private String patientName;
	private String doctorName;
	private String comments;
	private int totalAmt;
	@Override
	public String toString() {
		return "Prescriptionlist [presid=" + prescriptionId + ", patientname=" + patientName + ", doctorname=" + doctorName
				+ ", comments=" + comments + ", totalamt=" + totalAmt + "]";
	}
	
}

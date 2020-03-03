package com.chainsys.hmsapplication.model;

public class Prescriptionlist {
	private int presid;
	public int getPresid() {
		return presid;
	}
	public void setPresid(int presid) {
		this.presid = presid;
	}
	public String getPatientname() {
		return patientname;
	}
	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}
	public String getDoctorname() {
		return doctorname;
	}
	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public int getTotalamt() {
		return totalamt;
	}
	public void setTotalamt(int totalamt) {
		this.totalamt = totalamt;
	}
	private String patientname;
	private String doctorname;
	private String comments;
	private int totalamt;
	@Override
	public String toString() {
		return "Prescriptionlist [presid=" + presid + ", patientname=" + patientname + ", doctorname=" + doctorname
				+ ", comments=" + comments + ", totalamt=" + totalamt + "]";
	}
	
}

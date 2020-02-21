package com.vijaysankar.hmgsystems.doctors;

public class Doctorlist {
	@Override
	public String toString() {
		return "Doctorlist [doctorid=" + doctorid + ", doctorname=" + doctorname + ", splzationid=" + splzationid
				+ ", consultingfee=" + consultingfee + "]";
	}
	private int doctorid;
	public int getDoctorid() {
		return doctorid;
	}
	public void setDoctorid(int doctorid) {
		this.doctorid = doctorid;
	}
	public String getDoctorname() {
		return doctorname;
	}
	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}
	public int getSplzationid() {
		return splzationid;
	}
	public void setSplzationid(int splzationid) {
		this.splzationid = splzationid;
	}
	public int getConsultingfee() {
		return consultingfee;
	}
	public void setConsultingfee(int consultingfee) {
		this.consultingfee = consultingfee;
	}
	private String doctorname;
	private int splzationid;
	private int consultingfee;
			
}

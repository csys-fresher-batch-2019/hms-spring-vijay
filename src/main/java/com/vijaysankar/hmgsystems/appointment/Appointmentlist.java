package com.vijaysankar.hmgsystems.appointment;

import java.time.LocalDate;

public class Appointmentlist {
	private int appid;
	private int patientid;
	private String purpose;
	private int doctorid;
	private LocalDate appdate;
	@Override
	public String toString() {
		return "Appointmentlist [appid=" + appid + ", patientid=" + patientid + ", purpose=" + purpose + ", doctorid="
				+ doctorid + ", appdate=" + appdate + ", apptime=" + apptime + ", status=" + status + ", visited="
				+ visited + "]";
	}
	private String apptime;
	private String status;
	private String visited;
	private String email;
	public int getAppid() {
		return appid;
	}
	public void setAppid(int appid) {
		this.appid = appid;
	}
	public int getPatientid() {
		return patientid;
	}
	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public int getDoctorid() {
		return doctorid;
	}
	public void setDoctorid(int doctorid) {
		this.doctorid = doctorid;
	}
	public LocalDate getAppdate() {
		return appdate;
	}
	public void setAppdate(LocalDate appdate) {
		this.appdate = appdate;
	}
	public String getApptime() {
		return apptime;
	}
	public void setApptime(String apptime) {
		this.apptime = apptime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getVisited() {
		return visited;
	}
	public void setVisited(String visited) {
		this.visited = visited;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
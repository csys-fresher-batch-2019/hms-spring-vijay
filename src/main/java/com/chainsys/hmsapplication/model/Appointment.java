package com.chainsys.hmsapplication.model;

import java.time.LocalDate;

public class Appointment {
	private int appointmentId;
	private int patientId;
	private String purpose;
	private int doctorId;
	private LocalDate appointmentDate;
	@Override
	public String toString() {
		return "Appointmentlist [appid=" + appointmentId + ", patientid=" + patientId + ", purpose=" + purpose + ", doctorid="
				+ doctorId + ", appdate=" + appointmentDate + ", apptime=" + appointmentTime + ", status=" + status + ", visited="
				+ visited + "]";
	}
	private String appointmentTime;
	private String status;
	private String visited;
	private String email;
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
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
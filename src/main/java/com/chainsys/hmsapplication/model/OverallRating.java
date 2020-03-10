package com.chainsys.hmsapplication.model;

public class OverallRating {
	@Override
	public String toString() {
		return "Overallrating [doctor_id=" + doctorId + ", rating=" + rating + "]";
	}
	private int doctorId;
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctor_id) {
		this.doctorId = doctor_id;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	private float rating;
}

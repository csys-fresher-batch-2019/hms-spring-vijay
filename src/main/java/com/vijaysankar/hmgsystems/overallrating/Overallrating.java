package com.vijaysankar.hmgsystems.overallrating;

public class Overallrating {
	@Override
	public String toString() {
		return "Overallrating [doctor_id=" + doctor_id + ", rating=" + rating + "]";
	}
	private int doctor_id;
	public int getDoctor_id() {
		return doctor_id;
	}
	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	private float rating;
}

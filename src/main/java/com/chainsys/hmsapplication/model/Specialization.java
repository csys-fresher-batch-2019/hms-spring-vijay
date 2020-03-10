package com.chainsys.hmsapplication.model;

public class Specialization {
	@Override
	public String toString() {
		return "Splzationlist [splzationid=" + specializationId + ", Splzationname=" + specializationName + "]";
	}
	private int specializationId;

	public int getSpecializationId() {
		return specializationId;
	}

	public void setSpecializationId(int specializationId) {
		this.specializationId = specializationId;
	}

	public String getSpecializationName() {
		return specializationName;
	}

	public void setSpecializationName(String specializationName) {
		this.specializationName = specializationName;
	}
	private String specializationName;
	

}

package com.chainsys.hmsapplication.model;

public class Splzationlist {
	@Override
	public String toString() {
		return "Splzationlist [splzationid=" + splzationid + ", Splzationname=" + Splzationname + "]";
	}
	private int splzationid;
	public int getSplzationid() {
		return splzationid;
	}
	public void setSplzationid(int splzationid) {
		this.splzationid = splzationid;
	}
	public String getSplzationname() {
		return Splzationname;
	}
	public void setSplzationname(String splzationname) {
		Splzationname = splzationname;
	}
	private String Splzationname;
	

}

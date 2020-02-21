package com.vijaysankar.hmgsystems.appointment;

import java.util.ArrayList;

import com.vijaysankar.hmgsystems.dbexception.Dbexception;

public interface Interfaceapp {
	public void addappointment(Appointmentlist a) throws Dbexception;
	public void updateappointment(int pid) throws Dbexception;
	public void updatevisited(int aid) throws Dbexception;
	public ArrayList<Appointmentlist> viewapp() throws Dbexception;
	public ArrayList<Appointmentlist> viewpendingapp() throws Dbexception;
	public ArrayList<Appointmentlist> viewstatus() throws Dbexception ;
}

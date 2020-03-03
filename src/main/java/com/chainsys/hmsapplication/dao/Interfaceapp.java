package com.chainsys.hmsapplication.dao;

import java.util.ArrayList;

import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Appointmentlist;

public interface Interfaceapp {
	public void addappointment(Appointmentlist a) throws Dbexception;
	public void updateappointment(int pid) throws Dbexception;
	public void updatevisited(int aid) throws Dbexception;
	public ArrayList<Appointmentlist> viewapp() throws Dbexception;
	public ArrayList<Appointmentlist> viewpendingapp() throws Dbexception;
	public ArrayList<Appointmentlist> viewstatus() throws Dbexception ;
}

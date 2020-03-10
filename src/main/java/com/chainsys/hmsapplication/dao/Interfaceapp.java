package com.chainsys.hmsapplication.dao;

import java.util.List;

import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Appointmentlist;

public interface Interfaceapp {
	public void saveAppointment(Appointmentlist a) throws Dbexception;

	public void updateAppointment(int pid) throws Dbexception;

	public void updateVisited(int aid) throws Dbexception;

	public List<Appointmentlist> viewAppointment() throws Dbexception;

	public List<Appointmentlist> viewPendingAppointment() throws Dbexception;

	public List<Appointmentlist> viewStatus() throws Dbexception;
}

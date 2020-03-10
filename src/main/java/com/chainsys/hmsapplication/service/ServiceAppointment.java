package com.chainsys.hmsapplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chainsys.hmsapplication.dao.Interfaceapp;
import com.chainsys.hmsapplication.dao.impl.Impappointment;
import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Appointment;

@Service
public class ServiceAppointment {

	Interfaceapp la = new Impappointment();

	public void addappointment(Appointment a) throws Dbexception {

		la.saveAppointment(a);
	}

	public void updateappointment(int pid) throws Dbexception {
		la.updateAppointment(pid);

	}

	public void updatevisited(int aid) throws Dbexception {
		la.updateVisited(aid);

	}

	public List<Appointment> viewapp() throws Dbexception {
		return la.viewAppointment();

	}

	public List<Appointment> viewpendingapp() throws Dbexception {
		return la.viewPendingAppointment();

	}

	public List<Appointment> viewstatus() throws Dbexception {
		return la.viewStatus();

	}

}

package com.chainsys.hmsapplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chainsys.hmsapplication.dao.Interfaceapp;
import com.chainsys.hmsapplication.dao.impl.Impappointment;
import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Appointmentlist;

@Service
public class ServiceAppointment {

	Interfaceapp la = new Impappointment();

	public void addappointment(Appointmentlist a) throws Dbexception {

		la.saveAppointment(a);
	}

	public void updateappointment(int pid) throws Dbexception {
		la.updateAppointment(pid);

	}

	public void updatevisited(int aid) throws Dbexception {
		la.updateVisited(aid);

	}

	public List<Appointmentlist> viewapp() throws Dbexception {
		return la.viewAppointment();

	}

	public List<Appointmentlist> viewpendingapp() throws Dbexception {
		return la.viewPendingAppointment();

	}

	public List<Appointmentlist> viewstatus() throws Dbexception {
		return la.viewStatus();

	}

}

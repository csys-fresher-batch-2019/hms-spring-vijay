package com.chainsys.hmsapplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chainsys.hmsapplication.dao.AppointmentDao;
import com.chainsys.hmsapplication.dao.impl.AppointmentDaoImpl;
import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Appointment;

@Service
public class ServiceAppointment {

	AppointmentDao la = new AppointmentDaoImpl();

	public void appendAppointment(Appointment a) throws Dbexception {

		 la.saveAppointment(a);
	}

	public void updateAppointment(int pid) throws Dbexception {
		la.updateAppointment(pid);

	}

	public void updateVisited(int aid) throws Dbexception {
		la.updateVisited(aid);

	}

	public List<Appointment> viewAppointment() throws Dbexception {
		return la.viewAppointment();

	}

	public List<Appointment> viewPendingAppointment() throws Dbexception {
		return la.viewPendingAppointment();

	}

	public List<Appointment> viewStatus() throws Dbexception {
		return la.viewStatus();

	}

}

package com.chainsys.hmsapplication.dao;

import java.util.List;

import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Appointment;

public interface AppointmentDao {
	public void saveAppointment(Appointment a) throws Dbexception;

	public void updateAppointment(int pid) throws Dbexception;

	public void updateVisited(int aid) throws Dbexception;

	public List<Appointment> viewAppointment() throws Dbexception;

	public List<Appointment> viewPendingAppointment() throws Dbexception;

	public List<Appointment> viewStatus() throws Dbexception;
}

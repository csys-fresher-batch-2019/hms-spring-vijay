package com.chainsys.hmsapplication.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.chainsys.hmsapplication.dao.Interfaceapp;
import com.chainsys.hmsapplication.dao.impl.Impappointment;
import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Appointmentlist;
@Service
public class ServiceAppointment {
	
	Interfaceapp la = new Impappointment();
	
	public void addappointment(Appointmentlist a) throws Dbexception{
		
		la.addappointment(a);
			}
	public void updateappointment(int pid) throws Dbexception{
		la.updateappointment(pid);
		
	}
	public void updatevisited(int aid) throws Dbexception{
		la.updatevisited(aid);
		
	}
	public ArrayList<Appointmentlist> viewapp() throws Dbexception{
		return la.viewapp();
		
	}
	public ArrayList<Appointmentlist> viewpendingapp() throws Dbexception{
		return la.viewpendingapp();
		
	}
	public ArrayList<Appointmentlist> viewstatus() throws Dbexception {
		return la.viewstatus();
		
	}
	
}

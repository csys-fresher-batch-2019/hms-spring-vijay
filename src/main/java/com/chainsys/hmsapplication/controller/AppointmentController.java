package com.chainsys.hmsapplication.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.hmsapplication.dao.impl.Impappointment;
import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Appointmentlist;

@RestController
@RequestMapping("api")
public class AppointmentController {
	Impappointment app = new Impappointment();

	@PostMapping("/UpdateAppointmentStatus")
	public void updatestatus(@RequestParam("app_id") int appid) throws Dbexception {
		app.updateAppointment(appid);
	}

	@PostMapping("/UpdateAppointmentVisited")
	public void updatevisited(@RequestParam("app_id") int aid) throws Dbexception {
		app.updateVisited(aid);
	}

	@GetMapping("/ViewAppointments")
	public List<Appointmentlist> viewapp() {

		List<Appointmentlist> list = null;
		try {
			return list = app.viewAppointment();
		} catch (Dbexception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@PostMapping("/saveAppointment")
	public void addAppointment(@RequestParam("app_id") int appid, @RequestParam("patient_id") int pid,
			@RequestParam("purpose") String purpose, @RequestParam("doctor_id") int did,
			@RequestParam("app_date") String date, @RequestParam("app_time") String time) {

		Appointmentlist list = new Appointmentlist();
		list.setAppid(appid);
		list.setPatientid(pid);
		list.setPurpose(purpose);
		list.setDoctorid(did);
		LocalDate dates = LocalDate.parse(date);
		list.setAppdate(dates);
		list.setApptime(time);

		try {
			app.saveAppointment(list);
		} catch (Dbexception e) {
			e.printStackTrace();
		}
	}

}

package com.chainsys.hmsapplication.controller;

import java.util.ArrayList;

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
		app.updateappointment(appid);
	}

	@PostMapping("/UpdateAppointmentVisited")
	public void updatevisited(@RequestParam("app_id") int aid) throws Dbexception {
		app.updatevisited(aid);
	}

	@GetMapping("/ViewAppointments")
	public ArrayList<Appointmentlist> viewapp() {

		ArrayList<Appointmentlist> list = null;
		try {
			return list = app.viewapp();
		} catch (Dbexception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}

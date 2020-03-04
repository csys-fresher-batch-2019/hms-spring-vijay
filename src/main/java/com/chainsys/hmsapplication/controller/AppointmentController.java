package com.chainsys.hmsapplication.controller;

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
	
}

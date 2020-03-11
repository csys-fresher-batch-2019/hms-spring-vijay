package com.chainsys.hmsapplication.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.hmsapplication.dao.impl.Impappointment;
import com.chainsys.hmsapplication.dto.Message;
import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Appointment;

@RestController
@RequestMapping("api")
public class AppointmentController {
	Impappointment app = new Impappointment();

	@PostMapping("/UpdateAppointmentStatus")
	public ResponseEntity<?> updatestatus(@RequestParam("app_id") int appid) throws Dbexception {
		try{
			app.updateAppointment(appid);
		}catch(Dbexception e) {
			e.printStackTrace();
			Message msg= new Message();
			msg.setErrorMessage(e.getMessage());
			return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
			
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
		
	}

	@PostMapping("/UpdateAppointmentVisited")
	public void updatevisited(@RequestParam("app_id") int aid) throws Dbexception {
		app.updateVisited(aid);
	}

	@GetMapping("/ViewAppointments")
	public List<Appointment> viewapp() {

		List<Appointment> list = null;
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

		Appointment list = new Appointment();
		list.setAppointmentId(appid);
		list.setPatientId(pid);
		list.setPurpose(purpose);
		list.setDoctorId(did);
		LocalDate dates = LocalDate.parse(date);
		list.setAppointmentDate(dates);
		list.setAppointmentTime(time);

		try {
			app.saveAppointment(list);
		} catch (Dbexception e) {
			e.printStackTrace();
		}
	}

}

package com.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vijaysankar.hmgsystems.dbexception.Dbexception;
import com.vijaysankar.hmgsystems.doctors.Doctorlist;
import com.vijaysankar.hmgsystems.doctors.Impdoctor;

@RestController
@RequestMapping("api")
public class DoctorController {
	@GetMapping("/viewdoctors")
	public ArrayList<Doctorlist> viewdoctor() {
		
		Impdoctor doc=new Impdoctor();
		ArrayList<Doctorlist> ad=null;
		try {
			ad=doc.viewdoctor();
		} catch (Dbexception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ad;	
	}
}

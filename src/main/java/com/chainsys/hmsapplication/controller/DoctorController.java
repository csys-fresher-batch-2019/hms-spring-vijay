package com.chainsys.hmsapplication.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.hmsapplication.dao.impl.Impdoctor;
import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Doctorlist;

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

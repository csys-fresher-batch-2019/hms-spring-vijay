package com.chainsys.hmsapplication.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.hmsapplication.dao.impl.Impdoctor;
import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Doctorlist;

@RestController
@RequestMapping("api")
public class DoctorController {
	Impdoctor doc = new Impdoctor();

	@GetMapping("/viewdoctors")

	public ArrayList<Doctorlist> viewdoctor() {

		ArrayList<Doctorlist> ad = null;
		try {
			ad = doc.viewdoctor();
		} catch (Dbexception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ad;
	}

	@PostMapping("/addDoctor")
	public void addDoctor(@RequestParam("doctor_id") int docid, @RequestParam("doctor_name") String docname,
			@RequestParam("splzation_id") int splid, @RequestParam("consultingfee") int confee) {

		Doctorlist list = new Doctorlist();

		list.setDoctorid(docid);
		list.setDoctorname(docname);
		list.setSplzationid(splid);
		list.setConsultingfee(confee);

		try {
			doc.adddoctor(list);
		} catch (Dbexception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

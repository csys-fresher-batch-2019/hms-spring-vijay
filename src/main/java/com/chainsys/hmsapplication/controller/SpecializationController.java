package com.chainsys.hmsapplication.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.hmsapplication.dao.impl.SpecializationDaoImpl;
import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Specialization;

@RestController
@RequestMapping("api")

public class SpecializationController {
	
	SpecializationDaoImpl Impspl = new SpecializationDaoImpl();
	
	@GetMapping("/viewSpecialization")
	public List<Specialization> viewspl(){
		List<Specialization> list=null;
		
		try {
			list=Impspl.viewSpecialization();
		} catch (Dbexception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@GetMapping("/addSpecialization")
	public void addSpecialization(@RequestParam("splzation_id")int splzationid,@RequestParam("splzation_name")String Splzationname) {
	
		Specialization spl=new Specialization();
		spl.setSpecializationId(splzationid);
		spl.setSpecializationName(Splzationname);
		
		try {
			Impspl.saveSpecialization(spl);
		} catch (Dbexception e) {
			e.printStackTrace();
		}
		
		
}
}

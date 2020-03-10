package com.chainsys.hmsapplication.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.hmsapplication.dao.impl.Impspecialization;
import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Splzationlist;

@RestController
@RequestMapping("api")

public class SplzationController {
	
	Impspecialization Impspl = new Impspecialization();
	
	@GetMapping("/viewSpecialization")
	public ArrayList<Splzationlist> viewspl(){
		ArrayList<Splzationlist> list=null;
		
		try {
			list=Impspl.viewspl();
		} catch (Dbexception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@GetMapping("/addSpecialization")
	public void addSpecialization(@RequestParam("splzation_id")int splzationid,@RequestParam("splzation_name")String Splzationname) {
	
		Splzationlist spl=new Splzationlist();
		spl.setSplzationid(splzationid);
		spl.setSplzationname(Splzationname);
		
		try {
			Impspl.addspecialization(spl);
		} catch (Dbexception e) {
			e.printStackTrace();
		}
		
		
}
}

package com.chainsys.hmsapplication.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.hmsapplication.dao.Interfacedoctor;
import com.chainsys.hmsapplication.dao.impl.Impdoctor;
import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Doctorlist;
@Service
public class ServiceDoctor {
	@Autowired

	Interfacedoctor docs = new Impdoctor();

	public void adddoctor(Doctorlist addoc) throws Dbexception {
		docs.adddoctor(addoc);

	}

	public ArrayList<Doctorlist> viewdoctor() throws Dbexception {
		return docs.viewdoctor();

	}

	public ArrayList<String> doclist() throws Dbexception {
		return docs.doclist();

	}

	public ArrayList<Integer> doctorid() throws Dbexception {
		return docs.doctorid();

	}

}

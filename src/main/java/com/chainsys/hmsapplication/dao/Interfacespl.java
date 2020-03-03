package com.chainsys.hmsapplication.dao;

import java.util.ArrayList;

import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Splzationlist;

public interface Interfacespl {
	public void addspecialization(Splzationlist s) throws Dbexception ;
	public ArrayList<Splzationlist> viewspl() throws Dbexception;
	public ArrayList<Integer> getspl() throws Dbexception;
}

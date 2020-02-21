package com.vijaysankar.hmgsystems.splzations;

import java.util.ArrayList;

import com.vijaysankar.hmgsystems.dbexception.Dbexception;

public interface Interfacespl {
	public void addspecialization(Splzationlist s) throws Dbexception ;
	public ArrayList<Splzationlist> viewspl() throws Dbexception;
	public ArrayList<Integer> getspl() throws Dbexception;
}

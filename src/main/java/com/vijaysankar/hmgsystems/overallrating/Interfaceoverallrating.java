package com.vijaysankar.hmgsystems.overallrating;

import java.util.ArrayList;

import com.vijaysankar.hmgsystems.dbexception.Dbexception;

public interface Interfaceoverallrating {
	
	public void syncrating(Overallrating o) throws Dbexception;
	public void add(Overallrating o) throws Dbexception;
	public ArrayList<Overallrating> viewrating() throws Dbexception;

}

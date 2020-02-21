package com.vijaysankar.hmgsystems.doctors;

import java.util.ArrayList;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import com.vijaysankar.hmgsystems.dbexception.Dbexception;

public interface Interfacedoctor {
	public void adddoctor() throws Exception;
	public ArrayList<Doctorlist> viewdoctor() throws Dbexception;
	public ArrayList<String> doclist() throws Dbexception;
	public ArrayList<Integer> doctorid()throws Dbexception;
}

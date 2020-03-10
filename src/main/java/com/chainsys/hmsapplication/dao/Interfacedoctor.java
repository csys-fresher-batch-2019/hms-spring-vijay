package com.chainsys.hmsapplication.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import com.chainsys.hmsapplication.exception.Dbexception;
import com.chainsys.hmsapplication.model.Doctorlist;

public interface Interfacedoctor {
	public void adddoctor(Doctorlist addoc) throws Dbexception;
	public void addOverAllRating(Doctorlist addoc) throws Dbexception;
	public ArrayList<Doctorlist> viewdoctor() throws Dbexception;
	public ArrayList<String> doclist() throws Dbexception;
	public ArrayList<Integer> doctorid()throws Dbexception;
}

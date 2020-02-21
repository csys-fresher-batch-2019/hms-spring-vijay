package com.vijaysankar.hmgsystems.dbexception;

public class Dbexception extends Exception{
	
	public Dbexception(String msg)
	{
		super(msg);
	}

	public Dbexception(String string, Exception e) {
		super (string,e);
	}

}

package com.vijaysankar.hmgsystems.userrating;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.vijaysankar.hmgsystems.dbexception.Dbexception;
import com.vijaysankar.hmgsystems.overallrating.Impoverall;
import com.vijaysankar.hmgsystems.patientreg.connections;
import com.vijaysankar.hmgsystems.util.Logger;

public class Impuserrating {
	Logger logger=Logger.getInstance();
	
	public void addrating(Userrating adrating) throws Dbexception{
	
		String sql = "insert into rating values(?,?,?)";
		try(Connection con = connections.TestConnections();
		PreparedStatement pst= con.prepareStatement(sql);)
		{
		pst.setInt(1,adrating.getPatient_id());	
		pst.setInt(2,adrating.getDoctor_id());
		pst.setFloat(3,adrating.getRating());
		int row= pst.executeUpdate();
		logger.info(row);
		Impoverall obj=new Impoverall();
		obj.syncrating(adrating.getDoctor_id());
		
		}catch(Exception e) {
			throw new Dbexception("Insertion into Rating failed");
		}
		}
		}	

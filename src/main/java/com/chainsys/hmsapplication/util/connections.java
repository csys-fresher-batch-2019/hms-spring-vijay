package com.chainsys.hmsapplication.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.TimeZone;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.springframework.stereotype.Component;
@Component
public class connections {
	public static Connection TestConnections() throws Exception {
		TimeZone timeZone = TimeZone.getTimeZone("Asia/Kolkata");
		TimeZone.setDefault(timeZone);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
		System.out.println(connection);
		return connection;
	}
	
	public static Jdbi getJdbi() {
		Jdbi jdbi = null;
		try {
			Connection connection = TestConnections();
			jdbi = Jdbi.create(connection);
			jdbi.installPlugin(new SqlObjectPlugin());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return jdbi;
	}
}

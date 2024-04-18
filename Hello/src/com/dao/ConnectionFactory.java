package com.dao;

import java.sql.Connection;

import oracle.jdbc.pool.OracleDataSource;

public class ConnectionFactory {

	private static  OracleDataSource ds;
	private static  Connection con;

    @SuppressWarnings("finally")
	    public static Connection getCon() {
	
	          try {
		        ds = new OracleDataSource();

		        Class.forName("oracle.jdbc.driver.OracleDriver");
		        ds.setURL("jdbc:oracle:thin:@localhost:1521:xe");
	        	ds.setUser("SYSTEM");
	        	ds.setPassword("sql_me");
	        	con = ds.getConnection();
//		        System.out.println(con);
		
	           } 
	           catch (Exception e) {
		        System.out.println("ConnectionFactory"+e);
	           }
	           finally {
		        return con;
	           }	
        }
	
}

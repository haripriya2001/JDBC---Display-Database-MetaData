package com.priyasoft.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class DisplayDatabaseMetadata {

	public static void main(String[] args) {
		Connection con=null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			DatabaseMetaData md=con.getMetaData();
			System.out.println("Database Name\t:"+md.getDatabaseProductName());
			System.out.println("Database Version\t:"+md.getDatabaseProductVersion());
			System.out.println("Database Minor Version\t:"+md.getDriverMinorVersion());
			System.out.println("Database Major Version\t:"+md.getDriverMajorVersion());
			System.out.println("Database SQL keywords\t:"+md.getSQLKeywords());
			System.out.println("Database String Functions\t:"+md.getStringFunctions());
			System.out.println("Database Numneric Functions\t:"+md.getNumericFunctions());
			System.out.println("Is Support Batch Updates\t:"+md.supportsBatchUpdates());
			System.out.println("Is Support Stored Procedures\t:"+md.supportsStoredProcedures());
			}catch(Exception e)
		    {
			e.printStackTrace();
		    }finally{
		    	try{
		    		con.close();
		    	}catch(Exception e)
		    	{
		    		e.printStackTrace();
		    	}
		    }
	}

}

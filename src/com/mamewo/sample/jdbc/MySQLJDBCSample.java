package com.mamewo.sample.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLJDBCSample {
	static String HOST = System.getProperty("HOST", "localhost");
    public static void main(String argv[])
    {
	Statement stmt = null;
        try {
	System.out.println("HOST: "+HOST);
	    String url = "jdbc:mysql://"+HOST+"/test";
	    Class.forName ("com.mysql.jdbc.Driver").newInstance ();
	    //username, password 
	    Connection conn = DriverManager.getConnection (url, "root", "password");
	    String query = "select * from names";
	    stmt = conn.createStatement();
	    stmt.executeUpdate("create table names (name text(1024))");
	    stmt.executeUpdate("insert into names values ('hello')");
	    ResultSet result = stmt.executeQuery(query);
	    while(result.next()){
		System.out.println(result.getString("name"));
	    }

        }
	catch (Exception e) {
            e.printStackTrace();
        }
	finally {
	    try{
		if(stmt != null){
		    stmt.close();
		}
	    }
	    catch(Exception e){
		e.printStackTrace();
	    }
	}
    }
}


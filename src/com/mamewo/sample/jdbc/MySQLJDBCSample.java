package com.mamewo.sample.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLJDBCSample {
    public static void main(String argv[])
    {
	Statement stmt = null;
        try {
	    String url = "jdbc:mysql://localhost/test";
	    Class.forName ("com.mysql.jdbc.Driver").newInstance ();
	    //username, password 
	    Connection conn = DriverManager.getConnection (url);
	    String query = "select * from names";
	    stmt = conn.createStatement();
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


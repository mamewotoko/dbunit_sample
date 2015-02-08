package com.mamewo.sample.dbunit;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertTrue;
import org.dbunit.IDatabaseTester;
import java.io.File;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.csv.CsvDataSet;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.DBTestCase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class TestCSVDataSet
	extends DBTestCase
{
	static String HOST = System.getProperty("HOST", "localhost");
	static String URL = "jdbc:mysql://"+HOST+"/test";

    private IDatabaseTester databaseTester;

	public TestCSVDataSet(String name){
		super(name);
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, URL);
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root");
		System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "password");
	}

	protected IDataSet getDataSet()
		throws Exception
	{
		//data has
		//  csv files representing table rows
		//  table-ordering.txt which lists tables (i.e. csv file names without suffix)
		return new CsvDataSet(new File("data"));
	}
	
	public void testXXX(){
		Statement stmt = null;
        try {
			String url = "jdbc:mysql://"+HOST+"/test";
			Class.forName ("com.mysql.jdbc.Driver").newInstance ();
			//username, password 
			Connection conn = DriverManager.getConnection (url, "root", "password");
			String query = "select * from dbdata";
			stmt = conn.createStatement();
			stmt.executeUpdate("insert into dbdata values ('japanese'), ('english')");
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
		System.out.println("end of testXXX");
	}

	public void testYYY(){
				Statement stmt = null;
        try {
			String url = "jdbc:mysql://"+HOST+"/test";
			Class.forName ("com.mysql.jdbc.Driver").newInstance ();
			//username, password 
			Connection conn = DriverManager.getConnection (url, "root", "password");
			String query = "select * from dbdata";
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
		System.out.println("end of testYYY");
	}
}

package com.Super_li.DataBase;
import java.sql.*;

public class SQLiteJDBC implements DB_Sql{
	Connection c = null;
	public SQLiteJDBC(){}
	public boolean createConnection(){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:/home/yairganon/workspace_Java/Trucking/src/main/java/com/Super_li/DataBase/Super_li_db");

		} catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      return false;
		    }
		    return true;
	}
	public void closeConnection(){
		if (c!=null)
			try {
				c.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public boolean addDriver(String fullName, int id, char driverLicense) {
		try {
			Statement stmt = c.createStatement();
			String sql = "INSERT INTO tdb_driver (Id,FullName,DriverLicense) " +
	                   "VALUES ("+id+", '"+fullName+"','"+ driverLicense+"');"; 
		      stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}

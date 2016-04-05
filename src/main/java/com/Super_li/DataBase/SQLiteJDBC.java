package com.Super_li.DataBase;
import java.sql.*;

public class SQLiteJDBC implements DB_Sql{
	Connection c = null;
	public SQLiteJDBC(){}
	public boolean createConnection(){
		try {
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:/home/yairganon/workspace_Java/Trucking/src/main/java/com/Super_li/DataBase/Super_li_db");
		      c.setAutoCommit(false);
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
			PreparedStatement stmt = null;
			String sql = "INSERT INTO tdb_driver (Id,FullName,DriverLicense) " +
	                   "VALUES (?,?,?);"; 
			stmt = c.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.setString(2, fullName);
			stmt.setString(3, driverLicense+"");
			stmt.executeUpdate();
			c.commit();
		} catch (SQLException e) {
              try {
				c.rollback();
				return false;
			} catch (SQLException e1) {
				return false;
			}
		}
		return true;
	}
	public boolean UpdateDriver(int key,String fullName, int id, char driverLicense) {
		try {
			PreparedStatement stmt = null;
			String sql = "UPDATE tdb_driver SET Id = ? , FullName = ? ,  driverLicense = ? WHERE id = ?;"; 
			stmt = c.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.setString(2, fullName);
			stmt.setString(3, driverLicense+"");
			stmt.setInt(4, key);
			stmt.executeUpdate();
			c.commit();
		} catch (SQLException e) {
              try {
				c.rollback();
				return false;
			} catch (SQLException e1) {
				return false;
			}
		}
		return true;
	}
	public boolean addItem(String fullName, int weight) {
		try {
			PreparedStatement stmt = null;
			String sql = "INSERT INTO tdb_items (FullName,Weight) " +
	                   "VALUES (?,?);"; 
			stmt = c.prepareStatement(sql);
			stmt.setInt(2, weight);
			stmt.setString(1, fullName);
			stmt.executeUpdate();
			c.commit();
		} catch (SQLException e) {
              try {
            	 e.printStackTrace();
				c.rollback();
				return false;
			} catch (SQLException e1) {
				e1.printStackTrace();
				return false;
			}
		}
		return true;
	}
}

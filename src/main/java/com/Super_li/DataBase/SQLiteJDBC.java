package com.Super_li.DataBase;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import com.Super_li.Backend.Driver;
import com.Super_li.Backend.IdB_Entity;
import com.Super_li.Backend.Moving;
import com.Super_li.Backend.Orders;
import com.Super_li.Backend.Place;
import com.Super_li.Backend.Truck;

public class SQLiteJDBC{
	Connection c = null;
	Statement stmt = null;
	private SQLiteJDBC(){}
	private void createConnection() throws ClassNotFoundException, SQLException{
		Class.forName("org.sqlite.JDBC");
		c = DriverManager.getConnection("jdbc:sqlite:Super_li_db");
		c.setAutoCommit(false);
	}
	public static SQLiteJDBC getSQLiteJDBC() throws ClassNotFoundException, SQLException{
		SQLiteJDBC jdbc = new SQLiteJDBC();
		jdbc.createConnection();
		return jdbc;
	}
	public void closeConnection(){
		if (c!=null)
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public IdB_Entity isExists(IdB_Entity checkMeInDB){
		try {
			stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery( checkMeInDB.selectMe());
			if(rs.next()){
				checkMeInDB.updateFileds(rs);
				return checkMeInDB;
			}
			else 
				return null;
		} catch (SQLException e) {
			return null;
		}	
	}
	public boolean update(IdB_Entity toUpdate) {return dbCallUpdateDeleteRemove(toUpdate.update());}
	public boolean delete(IdB_Entity toDelete) {return dbCallUpdateDeleteRemove(toDelete.delete());}
	public boolean add(IdB_Entity toAdd) {return dbCallUpdateDeleteRemove(toAdd.addNew());}
	private boolean dbCallUpdateDeleteRemove(String execSql){
		try {
			stmt = c.createStatement();
			stmt.executeUpdate(execSql);
			c.commit();
		    stmt.close();
		    return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public List<Truck> getAllTrucks(){
		List<Truck>  list = new LinkedList<Truck>();
	    try {
			stmt = c.createStatement();
		    ResultSet rs = stmt.executeQuery( "SELECT * FROM Truck;" );
		    while ( rs.next() )
		    	list.add(new Truck(rs.getInt("Truck_ID"), rs.getString("Paint"), rs.getString("License"), rs.getString("Moudle"), rs.getDouble("Weight"), rs.getDouble("MaxWeight")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<Driver> getAllDrivers(){
		List<Driver>  list = new LinkedList<Driver>();
	    try {
			stmt = c.createStatement();
		    ResultSet rs = stmt.executeQuery( "SELECT * FROM Driver;" );
		    while ( rs.next() )
		    	list.add(new Driver(rs.getInt("Driver_ID"), rs.getString("Driver_FullName"), rs.getString("Driver_License")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<Place> getAlPlaces() {
		List<Place>  list = new LinkedList<Place>();
	    try {
			stmt = c.createStatement();
		    ResultSet rs = stmt.executeQuery( "SELECT * FROM Place;" );
		    while ( rs.next() )
		    	list.add(new Place(rs.getString("Adress"), rs.getString("Area"), rs.getString("Phone"),rs.getString("Contact")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}    
	public List<Orders> getAllOrders(){
		List<Orders>  list = new LinkedList<Orders>();
	    try {
			stmt = c.createStatement();
		    ResultSet rs = stmt.executeQuery( "SELECT * FROM Orders;" );
		    while ( rs.next() ){
		    	list.add(new Orders(rs.getInt("OrderID"),rs.getString("SourcePlace"), rs.getString("DestPlace"), rs.getInt("MovingID"),rs.getInt("ItemsInOrderID")));
		    }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	/*

this.movingId = rs.getInt("Moving_ID");
		this.date =;
		this.truckID = ;
		this.driverID =;
		this.hourOut = ;


	 */
	public List<Moving> getAllTruckings(){
		List<Moving>  list = new LinkedList<Moving>();
	    try {
			stmt = c.createStatement();
		    ResultSet rs = stmt.executeQuery( "SELECT * FROM Moving;" );
		    while ( rs.next() )
		    	list.add(new Moving(rs.getInt("Moving_ID"), rs.getString("Date"), rs.getInt("TruckID"),  rs.getInt("DriverID"), rs.getString("HourOut")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<Driver> getAllDrivers(String license){
		List<Driver>  list = new LinkedList<Driver>();
	    try {
			stmt = c.createStatement();
		    ResultSet rs = stmt.executeQuery( "SELECT * FROM Driver WHERE Driver_License='"+license+"';" );
		    while ( rs.next() )
		    	list.add(new Driver(rs.getInt("Driver_ID"), rs.getString("Driver_FullName"), rs.getString("Driver_License")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public void setMovingID(Moving m){
	    try {
			stmt = c.createStatement();
		    ResultSet rs = stmt.executeQuery( "SELECT Moving_ID FROM Moving WHERE "
			+"Date ='"+m.getDate()+"' AND TruckID ="+m.getTruck()+" AND DriverID ="+m.getDriver()+" AND HourOut ='"+m.getHourOut()+"';" );
		    while(rs.next())
		    	m.setMovingId(rs.getInt("Moving_ID"));
	    }
	catch (SQLException e) {
		e.printStackTrace();
	}
		
	}
}
	
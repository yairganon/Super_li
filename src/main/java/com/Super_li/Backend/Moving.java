package com.Super_li.Backend;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Moving implements IdB_Entity {
	private int movingId;
	private Truck truck;
	private Driver driver;
	private String date;
	private int truckID;
	private int driverID;
	private String hourOut;
	public Moving(int movingId){this.movingId=movingId;}
	public Moving(int movingId, String date, int truck, int driver, String hourOut) {
		super();
		this.movingId = movingId;
		this.date = date;
		this.truckID = truck;
		this.driverID = driver;
		this.hourOut = hourOut;
		this.truck = new Truck(truck);
		this.driver = new Driver(driver);
		this.truck.getLicense();
		this.driver.getID();
	}
	public Moving(String date, int truck, int driver, String hourOut) {
		super();
		this.date = date;
		this.truckID = truck;
		this.driverID = driver;
		this.hourOut = hourOut;
	}
	public String getDate() {return date;}
	public void setDate(String date) {this.date = date;}
	public int getTruck() {return truckID;}
	public void setTruck(int truck) {this.truckID = truck;}
	public int getDriver() {return driverID;}
	public void setDriver(int driver) {this.driverID = driver;}
	public String getHourOut() {return hourOut;}
	public void setHourOut(String hourOut) {this.hourOut = hourOut;}
	public int getMovingId() {return movingId;}
	public void setMovingId(int movingId) { this.movingId=movingId;}
	public String update() {return "UPDATE Moving SET Date ='"+date+"',TruckID ="+truckID+",DriverID ="+driverID+",HourOut ='"+hourOut+"' WHERE Moving_ID="+movingId+";";}
	public String addNew() {
		return "INSERT INTO Moving (Date,TruckID,DriverID,HourOut) " +
                "VALUES ('"+date+"',"+truckID+","+driverID+",'"+hourOut+"');";
	}
	public String delete() {return "DELETE FROM Moving WHERE Moving_ID="+movingId+";";}
	public String selectMe() {return "SELECT * FROM Moving WHERE Moving_ID="+movingId+";";}
	public void updateFileds(ResultSet rs) throws SQLException {
		this.movingId = rs.getInt("Moving_ID");
		this.date =rs.getString("Date");
		this.truckID = rs.getInt("TruckID");
		this.driverID = rs.getInt("DriverID");
		this.hourOut = rs.getString("HourOut");
	}
	
	@Override
	public String toString() {
		return "Moving [movingId=" + movingId + ", date=" + date + ", truck=" + truckID + ", driver=" + driverID
				+ ", hourOut=" + hourOut + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Moving other = (Moving) obj;
		if (movingId != other.movingId)
			return false;
		return true;
	}

	

}

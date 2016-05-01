package com.Super_li.Backend;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Driver implements IdB_Entity {
	private int id;
	private String fullName;
	private String license;
	public Driver(int id) {this.id = id;}
	public Driver(int id, String fullName, String license){
		this.id=id;
		this.fullName=fullName;
		this.license=license;
	}
	
	public int getID(){return id;}
	public String getFullName(){return fullName;}
	public String getLicense(){return license;}
	public void setFullname(String nextLine) {this.fullName= nextLine;}
	public void setLicense(String nextLine) {this.license=nextLine;}
	
	public String update() {return "UPDATE Driver SET Driver_FullName ='"+fullName+"',  Driver_License ='"+license+"' WHERE Driver_ID="+id+";";}
	public String addNew() {
		return "INSERT INTO Driver (Driver_ID ,Driver_FullName, Driver_License) " +
                "VALUES ("+id+",'"+fullName+"','"+license+"');"; 
	}
	public String delete() {return "DELETE FROM Driver " + "WHERE Driver_ID="+id+";";}
	public String selectMe() {return "SELECT * FROM Driver WHERE Driver_ID="+id+";";}
	public void updateFileds(ResultSet rs) throws SQLException {
		fullName = rs.getString("Driver_FullName");
		license = rs.getString("Driver_License");	
	}
	
	@Override
	public String toString() {
		return "Driver [id=" + id + ", fullName=" + fullName + ", license=" + license + "]";
		}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Driver other = (Driver) obj;
		if (id != other.id)
			return false;
		return true;
	}
	

}
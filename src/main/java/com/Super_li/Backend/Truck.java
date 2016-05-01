package com.Super_li.Backend;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Truck implements IdB_Entity {
	
	int truckId;
	String paint,license,moudle;
	double weight,maxWeight;
	public Truck(int id) {this.truckId=id;}
	public Truck(int truckId , String paint, String license,String moudle,double weight,double maxWeight){
		this.license = license;
		this.maxWeight = maxWeight;
		this.moudle =moudle;
		this.paint = paint;
		this.truckId = truckId;
		this.weight = weight;
	}
	
	
	public int getTruckId() {return truckId;}
	public String getPaint() {return paint;}
	public void setPaint(String paint) {this.paint = paint;}
	public String getLicense() {return license;}
	public void setLicense(String license) {this.license = license;}
	public String getMoudle() {return moudle;}
	public void setMoudle(String moudle) {this.moudle = moudle;}
	public double getWeight() {return weight;}
	public void setWeight(double weight) {this.weight = weight;}
	public double getMaxWeight() {return maxWeight;}
	public void setMaxWeight(double maxWeight) {this.maxWeight = maxWeight;}
	


	public String update() {return "UPDATE Truck SET Truck_ID ="+truckId+", Paint ='"+paint+"',Weight ="+weight+",MaxWeight ="+maxWeight+",License ='"+license+"',Moudle ='"+moudle+"' WHERE Truck_ID="+truckId+";";}
	public String addNew() {
		return "INSERT INTO Truck (Truck_ID,Paint,Weight,MaxWeight,License,Moudle) " +
                "VALUES ("+truckId+",'"+paint+"',"+weight+","+maxWeight+",'"+license+"','"+moudle+"');";
	}
	public String delete() {return "DELETE FROM Truck WHERE Truck_ID="+truckId+";";}
	public String selectMe() {return "SELECT * FROM Truck WHERE Truck_ID="+truckId+";";}
	public void updateFileds(ResultSet rs) throws SQLException {
		this.license = rs.getString("License");
		this.maxWeight = rs.getDouble("MaxWeight");
		this.moudle =rs.getString("Moudle");
		this.paint = rs.getString("Paint");
		this.truckId = rs.getInt("Truck_ID");
		this.weight = rs.getDouble("Weight");
	}


	@Override
	public String toString() {
		return "Truck [truckId=" + truckId + ", paint=" + paint + ", license=" + license + ", moudle=" + moudle
				+ ", weight=" + weight + ", maxWeight=" + maxWeight + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Truck other = (Truck) obj;
		if (truckId != other.truckId)
			return false;
		
		return true;
	}


}

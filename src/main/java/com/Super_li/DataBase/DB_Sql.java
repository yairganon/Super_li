package com.Super_li.DataBase;
public interface DB_Sql {
	public boolean createConnection();
	public void closeConnection();
	public boolean addDriver(String fullName, int id, char driverLicense);
}
